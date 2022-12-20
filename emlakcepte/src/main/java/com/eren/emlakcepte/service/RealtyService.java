package com.eren.emlakcepte.service;

import com.eren.emlakcepte.model.Realty;
import com.eren.emlakcepte.model.enums.RealtyKind;
import com.eren.emlakcepte.model.enums.RealtyStatus;
import com.eren.emlakcepte.model.enums.UserType;
import com.eren.emlakcepte.repository.RealtyRepository;
import com.eren.emlakcepte.request.RealtyRequest;
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

    @Autowired
    private BannerService bannerService;

    // Create Realty by checking user's limits
    public Realty createRealty(RealtyRequest realtyRequest) {
        String email = realtyRequest.getEmail();
        Realty realty = new Realty(realtyRequest.getNo(), realtyRequest.getTitle(), realtyRequest.getStatus(), realtyRequest.getKind(), realtyRequest.getType(), realtyRequest.getProvince(), realtyRequest.getDistrict());
        realty.setUser(userService.getUserByMail(email));
        if (UserType.INDIVIDUAL.equals(realty.getUser().getType())) {
            if (!realty.getKind().equals(RealtyKind.HOUSE)) {
                System.out.println("Individual users can have only house type realty");
                return null;

            }
            if (realty.getUser().getRealtyList().size() >= 3) {
                System.out.println("Individual users can have max 3 realty");
                return null;
            }
        }
        realty.setStatus(RealtyStatus.ACTIVE);
        realtyRepository.saveRealty(realty);
        userService.saveToUser(realty);
        bannerService.create(bannerService.firstBanner(realty));
        return realty;
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
