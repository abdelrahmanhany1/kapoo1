package com.example.demokapoo.repos;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demokapoo.entities.Game;

public interface GameRepository extends MongoRepository<Game, String> {

}
