package com.eren.emlakcepte.repository;

import com.eren.emlakcepte.model.Banner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BannerRepository {

    private static List<Banner> banners = new ArrayList<>();

    public void save(Banner banner) {
        banners.add(banner);
    }

    public List<Banner> findAll() {
        return banners;
    }

}
