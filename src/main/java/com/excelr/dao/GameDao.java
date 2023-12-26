// com.excelr.dao.GameDao.java
package com.excelr.dao;

import com.excelr.entity.Game;
import com.excelr.util.EntityManagerFactoryUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class GameDao {
    public void createGame(Game game) {
        EntityManager em = EntityManagerFactoryUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            em.persist(game);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public Game getGameById(Long gameId) {
        EntityManager em = EntityManagerFactoryUtil.getEntityManagerFactory().createEntityManager();
        Game game = em.find(Game.class, gameId);
        em.close();
        return game;
    }

    public void updateGame(Game updatedGame) {
        EntityManager em = EntityManagerFactoryUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            em.merge(updatedGame);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public void deleteGame(Long gameId) {
        EntityManager em = EntityManagerFactoryUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            Game game = em.find(Game.class, gameId);
            if (game != null) {
                em.remove(game);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}
