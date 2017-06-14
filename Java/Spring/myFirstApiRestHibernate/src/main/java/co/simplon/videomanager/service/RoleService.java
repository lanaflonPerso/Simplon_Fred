package co.simplon.videomanager.service;

import java.sql.Timestamp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.simplon.videomanager.domain.Role;
import co.simplon.videomanager.repository.RoleRepository;

/**
 * service gérant le role d'un acteur dans le film.
 * 
 * @author simplon
 *
 */
@Service
public class RoleService {
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private RoleRepository repo;

	public Iterable<Role> listFilms(Long idActor) throws Exception {
		return repo.findByActor(idActor);
	}

	public Iterable<Role> listActors(Long idFilm) throws Exception {
		return repo.findByFilm(idFilm);
	}
	
	public Role getRole(Long idActor, Long idFilm) throws Exception {
		Role role = null;
		try {
			role = repo.findOne(idActor, idFilm);
		} catch (Exception e) {
			log.error("Hibernate Error !: getRole", e);
			throw e;
		}
		return role;
	}
	
	public Role insertRole(Role role) throws Exception {
		try {
			role.setLastUpdate(new Timestamp(System.currentTimeMillis()));
			repo.save(role);
		} catch (Exception e) {
			log.error("Hibernate Error !: insertRole", e);
			throw e;
		}
		return role;
	}
	
	public void deleteRole(Long idActor, Long idFilm) throws Exception {
		try {
			repo.delete(idActor,idFilm);
		} catch (Exception e) {
			log.error("Hibernate Error !: deleteFilm", e);
			throw e;
		}
	}

}
