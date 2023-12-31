package com.example.demokapoo.entities;

public class Player {
    private String name;
    private int score;

    public Player() {
    }

    public Player(String name) {
        this.name = name;
        this.score = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Player [name=" + name + ", score=" + score + "]";
    }

}