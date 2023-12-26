// com.excelr.MainApp.java
package com.excelr;

import com.excelr.dao.GameDao;
import com.excelr.entity.Game;

public class MainApp {
    public static void main(String[] args) {
        GameDao gameDao = new GameDao();

        // Create
        Game newGame = new Game();
        newGame.setName("Sample Game");
        gameDao.createGame(newGame);

        // Read
        Game retrievedGame = gameDao.getGameById(newGame.getId());
        System.out.println("Retrieved Game: " + retrievedGame.getName());

        // Update
        retrievedGame.setName("Updated Game");
        gameDao.updateGame(retrievedGame);

        // Read Again
        Game updatedGame = gameDao.getGameById(newGame.getId());
        System.out.println("Updated Game: " + updatedGame.getName());

        // Delete
        gameDao.deleteGame(newGame.getId());
    }
}
