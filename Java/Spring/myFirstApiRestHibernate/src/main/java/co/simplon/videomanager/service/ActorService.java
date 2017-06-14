package co.simplon.videomanager.service;

import java.sql.Timestamp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.simplon.videomanager.domain.Actor;
import co.simplon.videomanager.repository.ActorRepository;

/**
 * service gérant l'acteur
 * C'est la couche métier.
 * 
 * @author simplon
 *
 */
@Service
public class ActorService {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ActorRepository repo;

	public Iterable<Actor> listActors(String search, String searchNew) throws Exception {
		try {
			if (! "".equals(searchNew))
				return repo.findNewActors(searchNew);
			else if (! "".equals(search))
				return repo.findByFirstNameContainingOrLastNameContaining(search, search);
			else
				return repo.findAll();
		} catch (Exception e) {
			log.error("Hibrnate Error !: listActors", e);
			throw e;
		}
	}

	public Actor getActor(Long id) throws Exception {
		Actor actor = null;
		try {
			actor = repo.findOne(id);
		} catch (Exception e) {
			log.error("Hibrnate Error !: getActor", e);
			throw e;
		}
		return actor;
	}

	public Actor insertActor(Actor actor) throws Exception {
		try {
			actor.setId(new Long(0));
			actor.setLastUpdate(new Timestamp(System.currentTimeMillis()));
			actor = repo.save(actor);
		} catch (Exception e) {
			log.error("Hibrnate Error !: insertActor", e);
			throw e;
		}
		return actor;
	}

	public void updateActor(Actor actor) throws Exception {
		try {
			actor.setLastUpdate(new Timestamp(System.currentTimeMillis()));
			repo.save(actor);
		} catch (Exception e) {
			log.error("Hibrnate Error !: updateActor", e);
			throw e;
		}
	}

	public void deleteActor(Long id) throws Exception {
		try {
			repo.delete(id);
		} catch (Exception e) {
			log.error("Hibrnate Error !: deleteActor", e);
			throw e;
		}
	}

}
