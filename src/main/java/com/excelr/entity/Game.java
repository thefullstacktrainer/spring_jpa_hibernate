// com.excelr.entity.Game.java
package com.excelr.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "game") // Specify the table name here
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // Constructors (including a no-argument constructor for JPA)
    public Game() {
    }

    public Game(String name) {
        this.name = name;
    }

    // Getter and setter for the 'name' property
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and setter for the 'id' property (if needed)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}