package com.sportradar;

public class Team {
    private String name;

    public static final Team Argentina = new Team("Argentina");
    public static final Team Australia = new Team("Australia");
    public static final Team Brazil = new Team("Brazil");
    public static final Team Canada = new Team("Canada");
    public static final Team France = new Team("France");
    public static final Team Germany = new Team("Germany");
    public static final Team Italy = new Team("Italy");
    public static final Team Mexico = new Team("Mexico");
    public static final Team Spain = new Team("Spain");
    public static final Team Uruguay = new Team("Uruguay");

    private Team(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}