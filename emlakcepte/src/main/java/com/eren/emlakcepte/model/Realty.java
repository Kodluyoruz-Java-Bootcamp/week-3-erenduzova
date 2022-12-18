package com.eren.emlakcepte.model;


import com.eren.emlakcepte.model.enums.RealtyKind;
import com.eren.emlakcepte.model.enums.RealtyStatus;
import com.eren.emlakcepte.model.enums.RealtyType;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Realty {

    private Long no;
    private String title;
    private LocalDateTime publishedDate = LocalDateTime.now();
    private User user;
    private RealtyStatus status;
    private RealtyKind kind;
    private RealtyType type;
    private String province;
    private String district;

    public Realty(Long no, String title, RealtyStatus status, RealtyKind kind, RealtyType type, String province, String district) {
        super();
        this.no = no;
        this.title = title;
        this.status = status;
        this.province = province;
        this.district = district;
        this.kind = kind;
        this.type = type;
    }

    public Long getNo() {
        return no;
    }
    public void setNo(Long no) {
        this.no = no;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public LocalDateTime getPublishedDate() {
        return publishedDate;
    }
    public void setPublishedDate(LocalDateTime publishedDate) {
        this.publishedDate = publishedDate;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    public RealtyStatus getStatus() {
        return status;
    }

    public void setStatus(RealtyStatus status) {
        this.status = status;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public RealtyKind getKind() {
        return kind;
    }

    public void setKind(RealtyKind kind) {
        this.kind = kind;
    }

    public RealtyType getType() {
        return type;
    }

    public void setType(RealtyType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Realty [no=" + no + ", title=" + title + ", publishedDate=" + publishedDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + ", user=" + user.getName()
                + ", status=" + status + ", kind=" + kind + ", type=" + type + ", province=" + province + "]";
    }

}
