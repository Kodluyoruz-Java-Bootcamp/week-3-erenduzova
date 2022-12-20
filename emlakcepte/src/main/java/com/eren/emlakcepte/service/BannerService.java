package com.eren.emlakcepte.service;

import com.eren.emlakcepte.model.Banner;
import com.eren.emlakcepte.model.Realty;
import com.eren.emlakcepte.repository.BannerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class BannerService {
    @Autowired
    private BannerRepository bannerRepository;
    @Autowired
    private UserService userService;

    @Autowired
    private RestTemplate restTemplate;

    final String ROOT_URI = "https://localhost:8080/banners";

    public List<Banner> getAllBanner() {
        ResponseEntity<Banner[]> response = restTemplate.getForEntity(ROOT_URI, Banner[].class);
        return Arrays.asList(response.getBody());

    }

    public HttpStatus addBanner(Banner banner) {
        ResponseEntity<HttpStatus> response = restTemplate.postForEntity(ROOT_URI, banner, HttpStatus.class);
        return response.getBody();
    }

    public Banner firstBanner(Realty realty) {
        return new Banner(String.valueOf(realty.getNo()), 1,
                realty.getUser().getPhone(), "",
                realty.getProvince() + realty.getDistrict());
    }

    /*
    public void create(Banner banner) {
        bannerRepository.save(banner);
        System.out.println("BannerService :: banner kaydedildi");
    }


    public List<Banner> getAll() {
        return bannerRepository.findAll();
    }
*/

}
