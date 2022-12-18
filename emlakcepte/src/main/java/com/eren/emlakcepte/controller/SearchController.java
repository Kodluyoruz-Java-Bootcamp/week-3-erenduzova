package com.eren.emlakcepte.controller;

import com.eren.emlakcepte.model.Realty;
import com.eren.emlakcepte.model.Search;
import com.eren.emlakcepte.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/search")
public class SearchController {

    @Autowired
    private SearchService searchService;

    @GetMapping(value = "/{email}")
    public List<Realty> search(@PathVariable String email, @RequestBody Search search) {
        return searchService.makeSearch(search, email);
    }

    // User's Past Searches
    @GetMapping(value = "/{email}/searched")
    public List<Search> getUsersSearches(@PathVariable String email) {
        return searchService.getPastSearches(email);
    }

    // Province Display limit = 10
    @GetMapping(value = "/{province}/display")
    public List<Realty> getDisplay(@PathVariable String province) {
        return searchService.provinceDisplay(province);
    }

    // Realty count by Province
    @GetMapping(value = "/{province}/count")
    public long getRealtyCountByProvince(@PathVariable String province) {
        return searchService.getCountByProvince(province);
    }

    // SALE HOUSE count by Province
    @GetMapping(value = "/{province}/count/house/sale")
    public long getHouseSaleByProvince(@PathVariable String province) {
        return searchService.getSaleHouseCount(province);
    }


}
