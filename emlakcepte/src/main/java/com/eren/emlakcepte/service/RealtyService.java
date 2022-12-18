package com.eren.emlakcepte.service;

import com.eren.emlakcepte.model.Realty;
import com.eren.emlakcepte.model.User;
import com.eren.emlakcepte.model.enums.RealtyKind;
import com.eren.emlakcepte.model.enums.RealtyStatus;
import com.eren.emlakcepte.model.enums.UserType;
import com.eren.emlakcepte.repository.RealtyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class RealtyService {

    @Autowired
    private RealtyRepository realtyRepository;

    @Autowired
    private UserService userService;

    // Create Realty by checking user's limits
    public String createRealty(Realty realty, String email) {
        realty.setUser(userService.getUserByMail(email));
        if (UserType.INDIVIDUAL.equals(realty.getUser().getType())) {
            if (!realty.getKind().equals(RealtyKind.HOUSE)) {
                return "Individual users can have only house type realty";

            }
            if (realty.getUser().getRealtyList().size() >= 3) {
                return "Individual users can have max 3 realty";
            }
        }
        realty.setStatus(RealtyStatus.ACTIVE);
        realtyRepository.saveRealty(realty);
        return ("createRealty : " + realty.getTitle());
    }

    public List<Realty> getAll() {
        return realtyRepository.findAll();
    }
/*
    public void printAll(List<Realty> realtyList) {
        realtyList.forEach(System.out::println);
    }
*/
    public List<Realty> getAllByUserEmail(String email) {
        return getAll().stream()
                .filter(realty -> realty.getUser().getMail().equals(email))
                .collect(Collectors.toList());
    }

    // Every user has unique email, but can have same name, search by email
    public List<Realty> getActiveRealtyByEmail(String email) {
        return getAll().stream()
                .filter(realty -> realty.getUser().getMail().equals(email))
                .filter(realty -> RealtyStatus.ACTIVE.equals(realty.getStatus()))
                .collect(Collectors.toList());

    }

}
