package com.talentsprint.otobisnow.bean;

public class BusBean {
    private String busNo;
    private Integer Capacity;
    private String isAvailable;
    private Integer busTypeId;
    private Integer busCategoryId;
    private Integer busDepoId;
    private String busDepo;
    private String busType;
    private String busCategory;

    public BusBean() {
    }

    public Integer getBusTypeId() {
        return this.busTypeId;
    }

    public String getBusDepo() {
        return this.busDepo;
    }

    public void setBusDepo(String busDepo) {
        this.busDepo = busDepo;
    }

    public String getBusType() {
        return this.busType;
    }

    public void setBusType(String busType) {
        this.busType = busType;
    }

    public String getBusCategory() {
        return this.busCategory;
    }

    public void setBusCategory(String busCategory) {
        this.busCategory = busCategory;
    }

    public void setBusTypeId(Integer busTypeId) {
        this.busTypeId = busTypeId;
    }

    public Integer getBusCategoryId() {
        return this.busCategoryId;
    }

    public void setBusCategoryId(Integer busCategoryId) {
        this.busCategoryId = busCategoryId;
    }

    public Integer getBusDepoId() {
        return this.busDepoId;
    }

    public void setBusDepoId(Integer busDepoId) {
        this.busDepoId = busDepoId;
    }

    public String getBusNo() {
        return this.busNo;
    }

    public void setBusNo(String busNo) {
        this.busNo = busNo;
    }

    public Integer getCapacity() {
        return this.Capacity;
    }

    public void setCapacity(Integer capacity) {
        this.Capacity = capacity;
    }

    public String getIsAvailable() {
        return this.isAvailable;
    }

    public void setIsAvailable(String isAvailable) {
        this.isAvailable = isAvailable;
    }
}