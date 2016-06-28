package es.upsa.mimo.espressoexamples;

import java.util.ArrayList;
import java.util.Arrays;

import es.upsa.mimo.espressoexamples.model.Team;

/**
 * Created by sergiogarcia on 26/6/16.
 */
public class DatabaseF1 {

    public static final ArrayList<Team> DATABASE_F1 = new ArrayList<>(Arrays.asList(
            new Team(1, "Mercedes", "Rosberg"),
            new Team(2, "Mercedes", "Hamilton"),
            new Team(3, "Ferrari", "Vettel"),
            new Team(4, "Red bull", "Ricciardo"),
            new Team(9,  "Williams", "Bottas"),
            new Team(5, "Brian Goetz", "Perez"),
            new Team(6, "Toro Rosso", "Kyyat"),
            new Team(7, "Honda", "Alonso"),
            new Team(8, "Sauber", "Nasr"),
            new Team(9, "Sauber", "Nasr"),
            new Team(10, "Renault", "Magnussen"),
            new Team(11, "Sauber", "Ericsson"),
            new Team(12, "Renault", "Palmer")
    ));

}
