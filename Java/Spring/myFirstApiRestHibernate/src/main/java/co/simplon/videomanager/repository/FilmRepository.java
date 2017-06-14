package co.simplon.videomanager.repository;

import org.springframework.data.repository.CrudRepository;

import co.simplon.videomanager.domain.Film;

public interface FilmRepository extends CrudRepository<Film, Long> {

}