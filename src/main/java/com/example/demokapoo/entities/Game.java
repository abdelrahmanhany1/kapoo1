package com.example.demokapoo.entities;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Game {
    @Id
    private String id;
    private String name;
    private LocalDateTime dateCreated;
    private List<Player> players;

    @JsonCreator
    public Game(@JsonProperty("name") String name, @JsonProperty("players") List<Player> players) {
        this.name = name;
        this.dateCreated = LocalDateTime.now();
        this.players = players;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    @Override
    public String toString() {
        return "Game [id=" + id + ", name=" + name + ", dateCreated=" + dateCreated + ", players=" + players + "]";
    }
}
