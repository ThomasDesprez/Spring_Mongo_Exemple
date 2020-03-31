package com.example.demo.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Voiture;
import com.example.demo.repositories.VoitureRepository;
import com.example.demo.services.VoitureService;

@Service
public class VoitureServiceImpl implements VoitureService {

	@Autowired
	private VoitureRepository repo;

	@Override
	public List<Voiture> findAll() {
		return this.repo.findAll();
	}

	@Override
	public Optional<Voiture> findById(String id) {
		return this.repo.findById(id);
	}

	@Override
	public Voiture update(Voiture v) {
		return this.repo.save(v);
	}

	@Override
	public void delete(String id) {
		this.repo.deleteById(id);
	}

	@Override
	public Voiture save(Voiture v) {
		return this.repo.save(v);
	}

	@Override
	public List<Voiture> findByMarque(String marque) {
		// TODO Auto-generated method stub
		return null;
	}

}
