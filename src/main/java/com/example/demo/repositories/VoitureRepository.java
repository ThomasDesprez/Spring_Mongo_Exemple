package com.example.demo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.models.Voiture;

public interface VoitureRepository extends MongoRepository<Voiture, String> {

}
