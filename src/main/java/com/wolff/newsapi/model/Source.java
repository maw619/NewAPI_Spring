package com.wolff.newsapi.model;

import javax.persistence.Table;

@Table
public class Source {

    private String id;

    private String name;

    public Source(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
