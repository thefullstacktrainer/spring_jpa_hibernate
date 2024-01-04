package com.excelr.collection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.excelr.collection.entity.Game;
import com.excelr.collection.entity.User;

public class StoreGameData {
    public static void main(String[] args) {

        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

        SessionFactory factory = meta.getSessionFactoryBuilder().build();
        Session session = factory.openSession();

        Transaction t = session.beginTransaction();

        User user = new User();
        user.setUsername("JohnDoe");

        Game game1 = new Game();
        game1.setTitle("The Legend of Zelda: Breath of the Wild");

        Game game2 = new Game();
        game2.setTitle("Red Dead Redemption 2");

        user.addGame(game1);
        user.addGame(game2);

        session.persist(user);

        t.commit();
        session.close();
        System.out.println("GameData stored successfully");
    }
}
