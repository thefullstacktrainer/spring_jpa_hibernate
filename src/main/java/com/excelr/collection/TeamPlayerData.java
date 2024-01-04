package com.excelr.collection;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.excelr.collection.entity.Player;
import com.excelr.collection.entity.Team;
import com.excelr.collection.entity.PlayerTeam;

public class TeamPlayerData {
    public static void main(String[] args) {

        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

        SessionFactory factory = meta.getSessionFactoryBuilder().build();
        Session session = factory.openSession();

        Transaction t = session.beginTransaction();

        // Creating players with more details
        Player player1 = new Player("Virat Kohli");
        Player player2 = new Player("Rohit Sharma");
        Player player3 = new Player("MS Dhoni");
        Player player4 = new Player("Shikhar Dhawan");
        Player player5 = new Player("KL Rahul");
        Player player6 = new Player("Hardik Pandya");
        Player player7 = new Player("Jasprit Bumrah");
        Player player8 = new Player("Ravindra Jadeja");
        Player player9 = new Player("Suresh Raina");
        Player player10 = new Player("David Warner");
        Player player11 = new Player("AB de Villiers");

        // Creating IPL teams
        Team rcb = new Team("Royal Challengers Bangalore");
        Team mi = new Team("Mumbai Indians");
        Team csk = new Team("Chennai Super Kings");
        Team dc = new Team("Delhi Capitals");

        // Persist players and teams first
        session.persist(player1);
        session.persist(player2);
        session.persist(player3);
        session.persist(player4);
        session.persist(player5);
        session.persist(player6);
        session.persist(player7);
        session.persist(player8);
        session.persist(player9);
        session.persist(player10);
        session.persist(player11);

        session.persist(rcb);
        session.persist(mi);
        session.persist(csk);
        session.persist(dc);

        // Setting up associations using the join table (player_team)
        Set<PlayerTeam> playerTeams = new HashSet<>();

        for (Player player : getAllPlayers(session)) {
            for (Team team : getAllTeams(session)) {
                PlayerTeam playerTeam = new PlayerTeam();
                playerTeam.setPlayer(player);
                playerTeam.setTeam(team);
                playerTeams.add(playerTeam);
            }
        }

        // Persisting data
        for (PlayerTeam playerTeam : playerTeams) {
            session.persist(playerTeam);
        }

        t.commit();
        session.close();
        System.out.println("IPL Team and Player data stored successfully");
    }

    @SuppressWarnings("unchecked")
    private static Set<Player> getAllPlayers(Session session) {
        return new HashSet<>(session.createQuery("FROM Player").getResultList());
    }

    @SuppressWarnings("unchecked")
    private static Set<Team> getAllTeams(Session session) {
        return new HashSet<>(session.createQuery("FROM Team").getResultList());
    }
}
