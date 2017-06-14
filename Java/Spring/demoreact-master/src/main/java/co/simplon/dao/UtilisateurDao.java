package co.simplon.dao;

import org.springframework.data.repository.CrudRepository;

import co.simplon.domain.Utilisateur;

public interface UtilisateurDao extends CrudRepository<Utilisateur, Long>{

}
