package com.eren.emlakcepte.request;

import com.eren.emlakcepte.model.enums.RealtyKind;
import com.eren.emlakcepte.model.enums.RealtyStatus;
import com.eren.emlakcepte.model.enums.RealtyType;

public class RealtyRequest {


    private Long no;
    private String title;
    private String email;
    private RealtyStatus status;
    private RealtyKind kind;
    private RealtyType type;
    private String province;
    private String district;


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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public RealtyStatus getStatus() {
        return status;
    }

    public void setStatus(RealtyStatus status) {
        this.status = status;
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
}
