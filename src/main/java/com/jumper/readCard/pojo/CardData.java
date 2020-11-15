package com.jumper.readCard.pojo;

import java.util.Date;

public class CardData {
    private String name;
    private String sex;
    private String nation;
    private String born;
    private String address;
    private String cardNo;
    private String police;
    private String activityLFrom;
    private String activityLTo;
    private String deviceNo;
    private Date date;
    private String begin;
    private String end;
    private String check;
    private String photoBuffer;

    @Override
    public String toString() {
        return "CardData{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", nation='" + nation + '\'' +
                ", born='" + born + '\'' +
                ", address='" + address + '\'' +
                ", cardNo='" + cardNo + '\'' +
                ", police='" + police + '\'' +
                ", activityLFrom='" + activityLFrom + '\'' +
                ", activityLTo='" + activityLTo + '\'' +
                ", deviceNo='" + deviceNo + '\'' +
                ", date=" + date +
                ", begin='" + begin + '\'' +
                ", end='" + end + '\'' +
                ", check='" + check + '\'' +
                ", photoBuffer='" + photoBuffer + '\'' +
                '}';
    }

    public String getBegin() {
        return begin;
    }

    public void setBegin(String begin) {
        this.begin = begin;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getCheck() {
        return check;
    }

    public void setCheck(String check) {
        this.check = check;
    }

    public CardData(String name, String sex, String nation, String born, String address, String cardNo, String police, String activityLFrom, String activityLTo, String deviceNo, String photoBuffer, Date date, String begin, String end, String check) {
        this.name = name;
        this.sex = sex;
        this.nation = nation;
        this.born = born;
        this.address = address;
        this.cardNo = cardNo;
        this.police = police;
        this.activityLFrom = activityLFrom;
        this.activityLTo = activityLTo;
        this.deviceNo = deviceNo;
        this.photoBuffer = photoBuffer;
        this.date = date;
        this.begin = begin;
        this.end = end;
        this.check = check;
    }

    public CardData() {
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

    public String getBorn() {
        return born;
    }

    public void setBorn(String born) {
        this.born = born;
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

    public String getPolice() {
        return police;
    }

    public void setPolice(String police) {
        this.police = police;
    }

    public String getActivityLFrom() {
        return activityLFrom;
    }

    public void setActivityLFrom(String activityLFrom) {
        this.activityLFrom = activityLFrom;
    }

    public String getActivityLTo() {
        return activityLTo;
    }

    public void setActivityLTo(String activityLTo) {
        this.activityLTo = activityLTo;
    }

    public String getDeviceNo() {
        return deviceNo;
    }

    public void setDeviceNo(String deviceNo) {
        this.deviceNo = deviceNo;
    }

    public String getPhotoBuffer() {
        return photoBuffer;
    }

    public void setPhotoBuffer(String photoBuffer) {
        this.photoBuffer = photoBuffer;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public CardData(String name, String sex, String nation, String born, String address, String cardNo, String police, String activityLFrom, String activityLTo, String deviceNo, String photoBuffer, Date date) {
        this.name = name;
        this.sex = sex;
        this.nation = nation;
        this.born = born;
        this.address = address;
        this.cardNo = cardNo;
        this.police = police;
        this.activityLFrom = activityLFrom;
        this.activityLTo = activityLTo;
        this.deviceNo = deviceNo;
        this.photoBuffer = photoBuffer;
        this.date = date;
    }
}
