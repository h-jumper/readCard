package com.jumper.readCard.pojo;

public class User {
    private Integer id;
    private String name;
    private String more;

    public User(Integer id, String name, String more) {
        this.id= id;
        this.name= name;
        this.more = more;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMore() {
        return more;
    }

    public void setMore(String more) {
        this.more = more;
    }
}
