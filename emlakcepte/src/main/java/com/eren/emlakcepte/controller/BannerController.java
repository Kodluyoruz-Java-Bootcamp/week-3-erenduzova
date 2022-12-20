package com.eren.emlakcepte.controller;

import com.eren.emlakcepte.model.Banner;
import com.eren.emlakcepte.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/banners")
public class BannerController {

    @Autowired
    private BannerService bannerService;

    @PostMapping
    public HttpStatus create(@RequestBody Banner banner) {
        return bannerService.addBanner(banner);
    }

    @GetMapping
    public ResponseEntity<List<Banner>> getAll() {
        return new ResponseEntity<>(bannerService.getAllBanner(), HttpStatus.OK);
    }



}
