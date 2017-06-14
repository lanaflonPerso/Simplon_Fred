package co.simplon.videomanager.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.common.AjaxResponseError;
import co.simplon.videomanager.domain.Film;
import co.simplon.videomanager.service.FilmService;

/**
 * Controleur REST de la classe Film
 * @author simplon
 *
 */
@RestController
@RequestMapping("/api/film")
public class FilmController {

	@Autowired
	FilmService filmService;

	/**
	 * Liste des films
	 * @return liste des films
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> listFilms() {
		Iterable<Film> listFilm;
		try {
			listFilm = filmService.listFilms();
		} catch (Exception e) {
			return AjaxResponseError.getErrorMessage(AjaxResponseError.ERROR_EXEC, e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(listFilm);
	}

	/**
	 * recherche d'un film. 
	 * 
	 * @param id id
	 * @return un film
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getfilm(@PathVariable("id") Long id) {
		Film film = null;
		try {
			film = filmService.getFilm(id);
		} catch (Exception e) {
			return AjaxResponseError.getErrorMessage(AjaxResponseError.ERROR_EXEC, e.getMessage());
		}
		if (film == null) {
			return AjaxResponseError.getErrorMessage(AjaxResponseError.ERROR_NOT_FOUND, "Not found");
		}
		return ResponseEntity.status(HttpStatus.OK).body(film);
	}

	/**
	 * creation d'un film
	 * 
	 * @param film film
	 * @param errors : erreur de validation
	 * @return : réponse de la requête
	 */
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> insertFilm(@Valid @RequestBody Film film, Errors errors) {

		// Si erreur de validation, retour erreur 400 (bad request), avec le
		// message d'erreur
		if (errors.hasErrors()) {
			return AjaxResponseError.extractErrorWhenIncompletRequest(errors);
		}

		try {
			film = filmService.insertFilm(film);
		} catch (Exception e) {
			return AjaxResponseError.getErrorMessage(AjaxResponseError.ERROR_EXEC, e.getMessage());
		}

		return ResponseEntity.status(HttpStatus.OK).body(film);
	}

	/**
	 * 
	 * @param film film
	 * @param errors : erreurs de validation
	 * @return : réponse de la requête
	 */
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<?> updateFilm(@Valid @RequestBody Film film, Errors errors) {
		// Si erreur de validation, retour erreur 400 (bad request), avec le
		// message d'erreur
		if (errors.hasErrors()) {
			return AjaxResponseError.extractErrorWhenIncompletRequest(errors);
		}

		try {
			filmService.updateFilm(film);
		} catch (Exception e) {
			return AjaxResponseError.getErrorMessage(AjaxResponseError.ERROR_EXEC, e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(film);
	}

	/**
	 * suppression d'un film
	 * 
	 * @param id id du film
	 * @return : réponse de la requête sans contenu
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteFilm(@PathVariable("id") Long id) {

		try {
			filmService.deleteFilm(id);;
		} catch (Exception e) {
			return AjaxResponseError.getErrorMessage(AjaxResponseError.ERROR_EXEC, e.getMessage());
		}

		return ResponseEntity.noContent().build();
	}

	
}
