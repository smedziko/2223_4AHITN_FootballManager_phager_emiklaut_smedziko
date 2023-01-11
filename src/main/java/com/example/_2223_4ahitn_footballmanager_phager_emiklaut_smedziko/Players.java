package com.example._2223_4ahitn_footballmanager_phager_emiklaut_smedziko;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Players {

    private String name;
    private String country_code;
    private int speed;
    private int shooting;
    private int dribbling;
    private int passing;
    private int defense;
    private int physis;

    public Players(String country_code){
        this.country_code = country_code;
    }

    private Players(ResultSet resultSet){
        try {
            this.country_code = resultSet.getString("country_code");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static ObservableList<Players> getPlayers(){
        Connection c = Database.getConnection();
        ObservableList<Players> list = FXCollections.observableArrayList();
        try {
            Statement s = c.createStatement();
            ResultSet results = s.executeQuery("SELECT country_code FROM players");
            while (results.next()){
                list.add(new Players(results));
            }
            results.close();
            s.close();
        } catch (SQLException e){
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public String toString() {
        return country_code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry_code() {
        return country_code;
    }

    public void setCountry_code(String country_code) {
        this.country_code = country_code;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getShooting() {
        return shooting;
    }

    public void setShooting(int shooting) {
        this.shooting = shooting;
    }

    public int getDribbling() {
        return dribbling;
    }

    public void setDribbling(int dribbling) {
        this.dribbling = dribbling;
    }

    public int getPassing() {
        return passing;
    }

    public void setPassing(int passing) {
        this.passing = passing;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getPhysis() {
        return physis;
    }

    public void setPhysis(int physis) {
        this.physis = physis;
    }
}

