package com.eren.emlakcepte.repository;



import com.eren.emlakcepte.model.Search;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class SearchRepository {

    private List<Search> searches = new ArrayList();

    public List<Search> getSearches() {
        return searches;
    }

    public void addSearch(Search search) {
        searches.add(search);
    }
}
