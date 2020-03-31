package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.models.Voiture;


public interface VoitureService {

	public List<Voiture> findAll();

	public Optional<Voiture> findById(String id);
	
	public List<Voiture> findByMarque(String marque);

	public Voiture update(Voiture v);

	public void delete(String id);

	public Voiture save(Voiture id);
}
