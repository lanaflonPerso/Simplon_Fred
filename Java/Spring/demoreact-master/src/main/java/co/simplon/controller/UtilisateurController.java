package co.simplon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.dao.UtilisateurDao;
import co.simplon.domain.Utilisateur;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/utilisateurs")

public class UtilisateurController {
	
	  @Autowired
	  private UtilisateurDao Dao;
	    
	  @RequestMapping(method=RequestMethod.GET)
	  
	  public Iterable<Utilisateur> getAll() {
		    return Dao.findAll();
		  }
}
