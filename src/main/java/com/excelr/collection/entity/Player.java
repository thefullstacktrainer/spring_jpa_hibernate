package com.excelr.collection.entity;

import java.util.Set;

public class Player {
    private Long id;
    private String name;
    private Set<Team> teams;

    public Player() {
    }

    public Player(String name) {
        this.name = name;
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public Player(Long id, String name, Set<Team> teams) {
		super();
		this.id = id;
		this.name = name;
		this.teams = teams;
	}

	public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Team> getTeams() {
        return teams;
    }

    public void setTeams(Set<Team> teams) {
        this.teams = teams;
    }
}
