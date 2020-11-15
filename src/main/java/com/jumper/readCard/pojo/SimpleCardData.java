package com.jumper.readCard.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class SimpleCardData {

    private String name;
    private String sex;
    private String nation;
    private String address;
    private String cardNo;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date date;
    private int countNum;

    @Override
    public String toString() {
        return "SimpleCardData{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", nation='" + nation + '\'' +
                ", address='" + address + '\'' +
                ", cardNo='" + cardNo + '\'' +
                ", date=" + date +
                ", countNum=" + countNum +
                '}';
    }

    public int getCountNum() {
        return countNum;
    }

    public void setCountNum(int countNum) {
        this.countNum = countNum;
    }

    public SimpleCardData(String name, String sex, String nation, String address, String cardNo, Date date, int countNum) {
        this.name = name;
        this.sex = sex;
        this.nation = nation;
        this.address = address;
        this.cardNo = cardNo;
        this.date = date;
        this.countNum = countNum;
    }

    public SimpleCardData() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public SimpleCardData(String name, String sex, String nation, String address, String cardNo, Date date) {
        this.name = name;
        this.sex = sex;
        this.nation = nation;
        this.address = address;
        this.cardNo = cardNo;
        this.date = date;
    }


}
