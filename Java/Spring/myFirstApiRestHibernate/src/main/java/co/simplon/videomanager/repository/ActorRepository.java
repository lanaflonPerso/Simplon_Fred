package co.simplon.videomanager.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import co.simplon.videomanager.domain.Actor;

public interface ActorRepository extends CrudRepository<Actor, Long> {
	
	/**
	 * recherche d'un acteur dont le nom ou prenom contient la zone de recherche
	 * @param firstname nom
	 * @param lastname prenom
	 * @return liste d'acteurs
	 */
	public Iterable<Actor> findByFirstNameContainingOrLastNameContaining(String firstname, String lastname);
	
	/**
	 * exemple de lecture personnalisee dans la base de donnees
	 * @param name nom
	 * @return liste d'acteurs
	 */
	@Query("from Actor where lastName like %?1% and id > 200")
	public Iterable<Actor> findNewActors(String name);

}