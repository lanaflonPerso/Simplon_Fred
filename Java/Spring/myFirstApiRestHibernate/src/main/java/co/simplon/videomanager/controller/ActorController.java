package co.simplon.videomanager.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.common.AjaxResponseError;
import co.simplon.videomanager.domain.Actor;
import co.simplon.videomanager.service.ActorService;

/**
 * Controleur REST de la classe Actor
 * @author simplon
 *
 */
@RestController
@RequestMapping("/api/actor")
public class ActorController {

	@Autowired
	ActorService actorService;

	/**
	 * Liste des acteurs
	 * @param search : critère de recherche
	 * @param searchnew : 2eme critere de recherche 
	 * @return liste des acteurs
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> listActors(@RequestParam(value="search", defaultValue="") String search, 
										@RequestParam(value="searchnew", defaultValue="") String searchnew) {
		Iterable<Actor> listActor;
		try {
			listActor = actorService.listActors(search, searchnew);
		} catch (Exception e) {
			return AjaxResponseError.getErrorMessage(AjaxResponseError.ERROR_EXEC, e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(listActor);
	}

	/**
	 * recherche d'un acteur. note : l'id est dans l'url et non en parametre
	 * 
	 * @param id : id de l'acteur
	 * @return : objet acteur
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getActor(@PathVariable("id") Long id) {
		Actor actor = null;
		try {
			actor = actorService.getActor(id);
		} catch (Exception e) {
			return AjaxResponseError.getErrorMessage(AjaxResponseError.ERROR_EXEC, e.getMessage());
		}
		if (actor == null) {
			return AjaxResponseError.getErrorMessage(AjaxResponseError.ERROR_NOT_FOUND, "Not found");
		}
		return ResponseEntity.status(HttpStatus.OK).body(actor);
	}

	/**
	 * creation d'un acteur
	 * 
	 * @param actor : acteur
	 * @param errors : erreur de validation
	 * @return : réponse de la requête
	 */
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> insertActor(@Valid @RequestBody Actor actor , Errors errors) {

		// Si erreur de validation, retour erreur 400 (bad request), avec le
		// message d'erreur
		if (errors.hasErrors()) {
			return AjaxResponseError.extractErrorWhenIncompletRequest(errors);
		}

		try {
			actor = actorService.insertActor(actor);
		} catch (Exception e) {
			return AjaxResponseError.getErrorMessage(AjaxResponseError.ERROR_EXEC, e.getMessage());
		}

		return ResponseEntity.status(HttpStatus.OK).body(actor);
	}
	
	/**
	 * 
	 * @param actor : acteur
	 * @param errors : erreurs de validation
	 * @return : réponse de la requête
	 */
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<?> updateActor(@Valid @RequestBody Actor actor, Errors errors) {
		// Si erreur de validation, retour erreur 400 (bad request), avec le
		// message d'erreur
		if (errors.hasErrors()) {
			return AjaxResponseError.extractErrorWhenIncompletRequest(errors);
		}

		try {
			actorService.updateActor(actor);
		} catch (Exception e) {
			return AjaxResponseError.getErrorMessage(AjaxResponseError.ERROR_EXEC, e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(actor);
	}

	/**
	 * suppression d'un acteur
	 * 
	 * @param id : id de l'acteur
	 * @return : réponse de la requête sans contenu
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteActor(@PathVariable("id") Long id) {

		try {
			actorService.deleteActor(id);
		} catch (Exception e) {
			return AjaxResponseError.getErrorMessage(AjaxResponseError.ERROR_EXEC, e.getMessage());
		}

		return ResponseEntity.noContent().build();
	}

	
}
