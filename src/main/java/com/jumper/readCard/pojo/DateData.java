package com.jumper.readCard.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class DateData {

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public DateData() {
    }

    public DateData(Date date) {
        this.date = date;
    }
}
