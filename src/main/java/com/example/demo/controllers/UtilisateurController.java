package com.example.demo.controllers;

import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Utilisateur;
import com.example.demo.models.Voiture;
import com.example.demo.services.UtilisateurService;

@RestController
@CrossOrigin
@RequestMapping("utilisateurs")
public class UtilisateurController {

	@Autowired
	private UtilisateurService service;

	@PostMapping("")
	public Utilisateur save(@RequestBody Utilisateur entity) {
		return this.service.save(entity);
	}

	@GetMapping("")
	public List<Utilisateur> findAll() {
		return this.service.findAll();
	}

	@GetMapping("{id}")
	public Optional<Utilisateur> findById(@PathVariable String id) {
		return this.service.findById(id);
	}

	@GetMapping("nom/{nom}")
	public List<Utilisateur> findAllByNom(@PathVariable String nom) {
		return this.service.findAllByNom(nom);

	}

	@PutMapping("")
	public Utilisateur update(@RequestBody Utilisateur u) {
		return this.service.update(u);
	}

	@DeleteMapping("{id}")
	public void deleteById(@PathVariable String id) {
		this.service.delete(id);
	}

	@DeleteMapping("")
	public void delete(@RequestBody Utilisateur u) {
		this.deleteById(u.getId());
	}

	@GetMapping("agegt/{age}")
	public List<Utilisateur> findAllByAgeGreaterThan(@PathVariable int age) {
		System.out.println("Age param : " + age);
		return this.service.findAllByAgeGreaterThan(age);
	}

	@PostMapping("{iduser}/{idvoiture}")
	public Utilisateur addVoiture(@PathVariable String iduser, @PathVariable String idvoiture) {
		return this.service.addVoiture(iduser, idvoiture);

	}

	@DeleteMapping("{iduser}/{idvoiture}")
	public Utilisateur deleteVoiture(@PathVariable String iduser, @PathVariable String idvoiture) {
		return this.service.deleteVoiture(iduser, idvoiture);

	}

	@GetMapping("{id}/voitures")
	public List<Voiture> findAllVoitureByUser(@PathVariable String id) {
		return this.service.findAllVoitureByUser(id);
	}

	@GetMapping("majors")
	public List<Utilisateur> findAllMajors() {
		return this.service.findAllMajors();
	}
}
