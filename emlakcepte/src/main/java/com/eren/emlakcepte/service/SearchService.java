package com.eren.emlakcepte.service;

import com.eren.emlakcepte.model.Realty;
import com.eren.emlakcepte.model.Search;
import com.eren.emlakcepte.model.enums.RealtyKind;
import com.eren.emlakcepte.model.enums.RealtyType;
import com.eren.emlakcepte.model.enums.SearchType;
import com.eren.emlakcepte.repository.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SearchService {

    @Autowired
    private SearchRepository searchRepository;
    @Autowired
    private RealtyService realtyService;
    @Autowired
    private UserService userService;

    public List<Realty> getAll() {
        return realtyService.getAll();
    }

    public List<Realty> getAllByProvince(String province) {
        return getAll().stream()
                .filter(realty -> realty.getProvince().equals(province)).collect(Collectors.toList());
    }

    public List<Realty> getAllByDistrict(String district) {
        return getAll().stream()
                .filter(realty -> realty.getDistrict().equals(district)).collect(Collectors.toList());

    }

    public void getCountByDistrict(String district) {
        System.out.println(district + " ilçesindeki ilanlar: ");
        System.out.println(getAll().stream()
                .filter(realty -> realty.getDistrict().equals(district)).count());
        ;

    }

    public long getCountByProvince(String province) {
        return getAll().stream()
                .filter(realty -> realty.getProvince().equals(province)).count();
    }

    public void createSearch(Search search) {
        searchRepository.addSearch(search);
    }

    // Make Search (Province or District Type)
    public List<Realty> makeSearch(Search search, String email) {
        search.setUser(userService.getUserByMail(email));
        createSearch(search);  // Save Search
        if (search.getSearchType().equals(SearchType.PROVINCE)) {
            return getAllByProvince(search.getSearchedWord());
        } else if (search.getSearchType().equals(SearchType.DISTRICT)) {
            return getAllByDistrict(search.getSearchedWord());
        }
        return null;  // Not a district, province search
    }

    public List<Search> getPastSearches(String email) {
        return searchRepository.getSearches().stream()
                .filter(search -> search.getUser().getMail().equals(email))
                .collect(Collectors.toList());
    }

/*
    public void findCount(Search search) {
        if (search.getSearchType().equals(SearchType.PROVINCE)) {
            getCountByProvince(search.getSearchedWord());
        } else if (search.getSearchType().equals(SearchType.DISTRICT)) {
            getCountByDistrict(search.getSearchedWord());
        }
    }
*/
    public long getSaleHouseCount(String province) {
       return getAll().stream()
                .filter(realty -> realty.getProvince().equals(province))
                .filter(realty -> realty.getKind().equals(RealtyKind.HOUSE))
                .filter(realty -> realty.getType().equals(RealtyType.SALE))
                .count();
    }


    // Display 10 Realty of province
    public List<Realty> provinceDisplay(String province) {
        return  getAll().stream().filter(realty -> realty.getProvince().equals(province))
                .limit(10).collect(Collectors.toList());
    }
}
