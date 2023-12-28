package com.example.demokapoo.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.demokapoo.entities.Game;
import com.example.demokapoo.entities.Player;
import com.example.demokapoo.services.GameService;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@RestController
public class GameController {
    @Autowired
    private GameService gameService;

    @RequestMapping(value = "/games", method=RequestMethod.GET)
    public List<Game> getAllGames() {
        return gameService.getAllGames();
    }

    @RequestMapping(value = "/games", method=RequestMethod.POST)
    public Game createGame(@RequestBody Game game){
        return gameService.createGame(game);
    }

    @RequestMapping(value = "/games/{id}", method = RequestMethod.GET)
    public Game getGame(@PathVariable("id") String id){
        return gameService.getGameWithId(id);
    }

    @RequestMapping(value = "/games/{id}/addRoundScores", method = RequestMethod.PUT)
    public Game addRoundScores(@PathVariable("id") String id, @RequestBody Map<String, Integer> scores) {
        return gameService.addRoundScores(id, scores);
    }

    @RequestMapping(value = "/games/{id}/players", method = RequestMethod.GET)
    public List<Player> getPlayersByGameId(@PathVariable("id") String gameId){
        return gameService.getPlayers(gameId);
    }
}
