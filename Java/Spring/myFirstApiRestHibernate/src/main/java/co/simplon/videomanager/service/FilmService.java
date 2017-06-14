package co.simplon.videomanager.service;

import java.sql.Timestamp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.simplon.videomanager.domain.Film;
import co.simplon.videomanager.repository.FilmRepository;

/**
 * service gérant le film.
 * 
 * @author simplon
 *
 */
@Service
public class FilmService {
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private FilmRepository repo;

	public Iterable<Film> listFilms() throws Exception {
		return repo.findAll();
	}

	public Film getFilm(Long id) throws Exception {
		Film film = null;
		try {
			film = repo.findOne(id);
		} catch (Exception e) {
			log.error("Hibrnate Error !: getFilm", e);
			throw e;
		}
		return film;
	}

	public Film insertFilm(Film film) throws Exception {
		try {
			film.setId(new Long(0));
			film.setLastUpdate(new Timestamp(System.currentTimeMillis()));
			film = repo.save(film);
		} catch (Exception e) {
			log.error("Hibrnate Error !: insertFilm", e);
			throw e;
		}
		return film;
	}

	public void updateFilm(Film film) throws Exception {
		try {
			film.setLastUpdate(new Timestamp(System.currentTimeMillis()));
			repo.save(film);
		} catch (Exception e) {
			log.error("Hibrnate Error !: updateFilm", e);
			throw e;
		}
	}

	public void deleteFilm(Long id) throws Exception {
		try {
			repo.delete(id);
		} catch (Exception e) {
			log.error("Hibrnate Error !: deleteFilm", e);
			throw e;
		}
	}

}
