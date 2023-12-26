package com.h2dbexample;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GameH2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // Constructors (including a no-argument constructor for JPA)
    public GameH2() {
    }

    public GameH2(String name) {
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
