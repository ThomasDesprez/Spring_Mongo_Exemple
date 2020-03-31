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

import com.example.demo.models.Voiture;
import com.example.demo.services.VoitureService;

@RestController
@CrossOrigin
@RequestMapping("voitures")
public class VoitureController {

	@Autowired
	private VoitureService service;

	@PostMapping("")
	public Voiture save(@RequestBody Voiture entity) {
		return this.service.save(entity);
	}

	@GetMapping("")
	public List<Voiture> findAll() {
		return this.service.findAll();
	}

	@GetMapping("{id}")
	public Optional<Voiture> findById(@PathVariable String id) {
		return this.service.findById(id);
	}

	@GetMapping("marque/{nom}")
	public List<Voiture> findAllByNom(@PathVariable String marque) {
		return null;

	}

	@PutMapping("")
	public Voiture update(@RequestBody Voiture u) {
		return this.service.update(u);
	}

	@DeleteMapping("{id}")
	public void deleteById(@PathVariable String id) {
		this.service.delete(id);
	}

	@DeleteMapping("")
	public void delete(@RequestBody Voiture u) {
		this.deleteById(u.getId());
	}

//	public List<Voiture> findAllVoitures(@PathVariable Utilisateur u) {
//		return this.service.findAllVoitures(u);
//	}

}
