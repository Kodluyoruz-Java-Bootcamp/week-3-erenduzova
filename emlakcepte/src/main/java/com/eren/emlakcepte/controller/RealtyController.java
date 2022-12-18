package com.eren.emlakcepte.controller;

import com.eren.emlakcepte.model.Realty;
import com.eren.emlakcepte.service.RealtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/realty")
public class RealtyController {

    @Autowired
    private RealtyService realtyService;

    // Get All Realty
    @GetMapping
    public List<Realty> getAllRealty() {
        return realtyService.getAll();
    }

    // Create Realty
    @PostMapping(value = "/{email}/create")
    public String create(@RequestBody Realty realty, @PathVariable String email) {
        return realtyService.createRealty(realty, email);
    }


    // Get User's Active Realty
    @GetMapping(value = "/{email}/active")
    public List<Realty> getActiveRealty(@PathVariable String email) {
        return realtyService.getActiveRealtyByEmail(email);
    }

    // Get User's All Realty
    @GetMapping(value = "/{email}/all")
    public List<Realty> getAllRealty(@PathVariable String email) {
        return realtyService.getAllByUserEmail(email);
    }

}
