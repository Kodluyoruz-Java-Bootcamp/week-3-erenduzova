package com.eren.emlakcepte.repository;


import com.eren.emlakcepte.model.Realty;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class RealtyRepository {

    private static List<Realty> realtyList = new ArrayList<>();


    public void saveRealty(Realty realty) {
        realtyList.add(realty);
    }

    public List<Realty> findAll(){
        return realtyList;
    }


}
