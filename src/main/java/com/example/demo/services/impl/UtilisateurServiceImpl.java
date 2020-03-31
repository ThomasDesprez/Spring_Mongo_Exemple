package com.example.demo.services.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Utilisateur;
import com.example.demo.models.Voiture;
import com.example.demo.repositories.UtilisateurRepository;
import com.example.demo.services.UtilisateurService;
import com.example.demo.services.VoitureService;

@Service
public class UtilisateurServiceImpl implements UtilisateurService {

	@Autowired
	private VoitureService voitureService;
	@Autowired
	private UtilisateurRepository repo;

	@Override
	public List<Utilisateur> findAll() {
		return this.repo.findAll();
	}

	@Override
	public Optional<Utilisateur> findById(String id) {
		return this.repo.findById(id);
	}

	@Override
	public Utilisateur update(Utilisateur u) {
		return this.repo.save(u);
	}

	@Override
	public void delete(String id) {
		this.repo.deleteById(id);
	}

	@Override
	public Utilisateur save(Utilisateur u) {
		return this.repo.save(u);
	}

	@Override
	public List<Utilisateur> findAllByNom(String nom) {
		return this.repo.findAllByNom(nom);
	}

	public List<Voiture> findAllVoitureByUser(String id) {
		Optional<Utilisateur> user = this.findById(id);
		if (!user.isPresent())
			return null;
		return user.get().getVoitures();
	}

	@Override
	public List<Utilisateur> findAllByAgeGreaterThan(int age) {
		LocalDate now = LocalDate.now();
		return this.repo.findByNaissanceLessThan(now.minusYears((long) age));

	}

	@Override
	public Utilisateur addVoiture(String iduser, String idvoiture) {

		if (!this.findById(iduser).isPresent() || !voitureService.findById(idvoiture).isPresent())
			return null;

		Utilisateur u = this.findById(iduser).get();
		Optional<Voiture> v = voitureService.findById(idvoiture);
		Voiture voiture = v.get();
		u.getVoitures().add(voiture);
		this.update(u);

		return u;
	}

	public Utilisateur deleteVoiture(String iduser, String idvoiture) {
		if (!this.findById(iduser).isPresent() || !voitureService.findById(idvoiture).isPresent())
			return null;

		Utilisateur u = this.findById(iduser).get();
		Optional<Voiture> v = voitureService.findById(idvoiture);
		Voiture voiture = v.get();
		List<Voiture> voitures = u.getVoitures();
		voitures.forEach(voit -> {
			if (idvoiture == voit.getId())
				u.getVoitures().remove(voit);

		});
		u.getVoitures().remove(voiture);
		this.update(u);

		return u;
	}

	@Override
	public List<Utilisateur> findAllMajors() {
		List<Utilisateur> usersMajors = this.findAllByAgeGreaterThan(18);
		return usersMajors;
	}

}
