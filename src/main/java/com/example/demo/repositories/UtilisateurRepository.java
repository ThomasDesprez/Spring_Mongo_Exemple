package com.example.demo.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.models.Utilisateur;

public interface UtilisateurRepository extends MongoRepository<Utilisateur, String> {

	public List<Utilisateur> findAllByNom(String nom);

	public List<Utilisateur> findByNaissanceLessThan(LocalDate date);

	public List<Utilisateur> findAll();
}
