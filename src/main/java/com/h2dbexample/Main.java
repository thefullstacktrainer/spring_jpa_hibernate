package com.h2dbexample;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.excelr.entity.Game;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gamePU");
        EntityManager em = emf.createEntityManager();

        // Example: Create a new game
        em.getTransaction().begin();
        Game game = new Game();
        game.setName("Volarant Game 2");
        em.persist(game);
        em.getTransaction().commit();

        // Example: Retrieve a game by ID
        em.getTransaction().begin();
        Game retrievedGame = em.find(Game.class, 1L);
        System.out.println("Retrieved Game: " + retrievedGame.getName());
        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
