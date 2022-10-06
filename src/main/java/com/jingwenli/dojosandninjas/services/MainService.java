package com.jingwenli.dojosandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jingwenli.dojosandninjas.models.Dojo;
import com.jingwenli.dojosandninjas.models.Ninja;
import com.jingwenli.dojosandninjas.repositories.DojoRepository;
import com.jingwenli.dojosandninjas.repositories.NinjaRepository;

@Service
public class MainService {

	@Autowired
	private DojoRepository dojoRepository;
	
	@Autowired
	private NinjaRepository ninjaRepository;
	
//	FIND ALL dojos
	public List<Dojo> allDojos() {
		return dojoRepository.findAll();
	}

//	CREATE A NEW DOJO
	public Dojo createNewDojo(Dojo dojo) {
		return dojoRepository.save(dojo);
	}
	
//	CREATE A NEW NINJA
	public Ninja createNewNinja(Ninja ninja) {
		return ninjaRepository.save(ninja);
	}
	
//	FIND ONE DOJO
	public Dojo findOneDojo(Long id) {
		Optional<Dojo> optionalDojo = dojoRepository.findById(id);
		if (optionalDojo.isPresent()) {
			return optionalDojo.get();		
		} else {
			return null;
		}
	}
}

