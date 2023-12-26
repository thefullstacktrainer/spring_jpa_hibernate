package com.h2dbexample;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gamePU");
        EntityManager em = emf.createEntityManager();

        // Example: Create a new game
        em.getTransaction().begin();
        GameH2 game = new GameH2();
        game.setName("Volarant Game");
        em.persist(game);
        em.getTransaction().commit();

        // Example: Retrieve a game by ID
        em.getTransaction().begin();
        GameH2 retrievedGame = em.find(GameH2.class, 1L);
        System.out.println("Retrieved Game: " + retrievedGame.getName());
        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
