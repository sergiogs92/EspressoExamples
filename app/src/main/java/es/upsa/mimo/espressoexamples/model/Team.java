package es.upsa.mimo.espressoexamples.model;

/**
 * Created by sergiogarcia on 26/6/16.
 */
public class Team {
    public final Integer id;
    public final String name;
    public final String driver;

    public Team(int id, String name , String driver) {
        this.id = id;
        this.name = name;
        this.driver = driver;
    }
}