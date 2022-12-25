package com.eren.emlakcepte.model;


import com.eren.emlakcepte.model.enums.SearchType;

public class Search {

    private SearchType searchType;
    private User user;
    private String searchedWord;

    public Search(SearchType searchType, String searchedWord) {
        this.searchType = searchType;
        this.searchedWord = searchedWord;
    }

    public SearchType getSearchType() {
        return searchType;
    }

    public void setSearchType(SearchType searchType) {
        this.searchType = searchType;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getSearchedWord() {
        return searchedWord;
    }

    public void setSearchedWord(String searchedWord) {
        this.searchedWord = searchedWord;
    }

    @Override
    public String toString() {
        return "Search{" +
                "searchType=" + searchType +
                ", user=" + user.getName() +
                ", searchedWord='" + searchedWord + '\'' +
                '}';
    }
}
