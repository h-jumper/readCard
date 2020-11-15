package com.jumper.readCard.pojo;

import java.util.List;

public class Go {

    private String mark;
    private List<DateData> dateData;

    public Go(String mark, List<DateData> dateData) {
        this.mark = mark;
        this.dateData = dateData;
    }

    public Go() {
    }

    @Override
    public String toString() {
        return "Go{" +
                "mark='" + mark + '\'' +
                ", dateData=" + dateData +
                '}';
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public List<DateData> getDateData() {
        return dateData;
    }

    public void setDateData(List<DateData> dateData) {
        this.dateData = dateData;
    }
}
