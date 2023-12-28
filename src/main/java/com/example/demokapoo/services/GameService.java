package com.example.demokapoo.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demokapoo.entities.Game;
import com.example.demokapoo.entities.Player;
import com.example.demokapoo.repos.GameRepository;

@Service
public class GameService {
    @Autowired
    private GameRepository gameRepository;

    public List<Game> getAllGames() {
        // Get all games from the repository
        List<Game> allGames = gameRepository.findAll();

        // Sort the games by dateCreated in descending order (newest to oldest)
        List<Game> sortedGames = allGames.stream()
                .sorted((game1, game2) -> game2.getDateCreated().compareTo(game1.getDateCreated()))
                .collect(Collectors.toList());

        return sortedGames;
    }

    public Game getGameWithId(String id){
        return gameRepository.findById(id).orElseThrow(() -> new RuntimeException("Game not found!"));
    }

    public Game createGame(Game game) {
        // Set the dateCreated before saving the game
        game.setDateCreated(LocalDateTime.now());
        return gameRepository.save(game);
    }

    public Game addRoundScores(String gameId, Map<String, Integer> scores) {
        Game game = gameRepository.findById(gameId).orElseThrow(() -> new RuntimeException("Game not found"));

        List<Player> players = game.getPlayers();
        for (Player player : players) {
            String playerName = player.getName();
            if (scores.containsKey(playerName)) {
                int currentScore = player.getScore();
                int newScore = currentScore + scores.get(playerName);
                player.setScore(newScore);
            }
        }

        return gameRepository.save(game);
    }

    public List<Player> getPlayers(String gameId){
        Game game = gameRepository.findById(gameId).orElseThrow(() -> new RuntimeException("Game not found"));
        return game.getPlayers();
    }
}
