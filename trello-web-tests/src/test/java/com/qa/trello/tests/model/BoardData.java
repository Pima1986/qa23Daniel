package com.qa.trello.tests.model;

public class BoardData {
    private String name;

    public BoardData withName(String name) {
        this.name = name;
        return this;
    }

    public String getName() {

        return name;
    }

}
