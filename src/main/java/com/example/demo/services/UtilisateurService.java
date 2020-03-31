package com.example.demo.services;

import java.util.List;

import java.util.Optional;

import com.example.demo.models.Utilisateur;
import com.example.demo.models.Voiture;

public interface UtilisateurService {

	public List<Utilisateur> findAll();

	public Optional<Utilisateur> findById(String id);

	public Utilisateur update(Utilisateur u);

	public void delete(String id);

	public Utilisateur save(Utilisateur id);

	public List<Utilisateur> findAllByNom(String nom);

	public List<Utilisateur> findAllByAgeGreaterThan(int age);

	public Utilisateur addVoiture(String iduser, String idvoiture);
	
	public Utilisateur deleteVoiture(String iduser, String idvoiture);
	
	public List<Voiture> findAllVoitureByUser(String id);
	
	public List<Utilisateur> findAllMajors();

}
