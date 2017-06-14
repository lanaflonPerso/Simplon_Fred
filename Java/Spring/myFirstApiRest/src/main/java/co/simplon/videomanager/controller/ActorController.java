package co.simplon.videomanager.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.study.domain.AjaxResponseBody;
import co.simplon.videomanager.domain.Actor;
import co.simplon.videomanager.service.ActorService;

@RestController
@RequestMapping("/api/actor")
public class ActorController {

	@Autowired
	ActorService actorService;

	/**
	 * Liste des acteurs
	 * 
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> listActors(@RequestParam(value="search", defaultValue="") String search) {
		List<Actor> listActor;
		try {
			listActor = actorService.listActors(search);
		} catch (Exception e) {
			return returnErrorMessage(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(listActor);
	}

	/**
	 * recherche d'un acteur. note : l'id est dans l'url et non en parametre
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getActor(@PathVariable("id") Long id) {
		Actor actor = null;
		try {
			actor = actorService.getActor(id);
		} catch (Exception e) {
			return returnErrorMessage(e.getMessage());
		}
		if (actor == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(actor);
	}

	/**
	 * creation d'un acteur
	 * 
	 * @param actor
	 * @param errors
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> insertActor(@Valid @RequestBody Actor actor, Errors errors) {

		// Si erreur de validation, retour erreur 400 (bad request), avec le
		// message d'erreur
		if (errors.hasErrors()) {
			String message = errors.getAllErrors().stream().map(x -> x.getDefaultMessage())
					.collect(Collectors.joining(","));
			return returnErrorMessage(message);
		}

		try {
			actor = actorService.insertActor(actor);
		} catch (Exception e) {
			return returnErrorMessage(e.getMessage());
		}

		return ResponseEntity.status(HttpStatus.OK).body(actor);
	}

	/**
	 * 
	 * @param actor
	 * @param errors
	 * @return
	 */
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<?> atualizar(@Valid @RequestBody Actor actor, Errors errors) {
		// Si erreur de validation, retour erreur 400 (bad request), avec le
		// message d'erreur
		if (errors.hasErrors()) {
			String message = errors.getAllErrors().stream().map(x -> x.getDefaultMessage())
					.collect(Collectors.joining(","));
			return returnErrorMessage(message);
		}

		try {
			actorService.updateActor(actor);
		} catch (Exception e) {
			return returnErrorMessage(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(actor);
	}

	/**
	 * suppression d'un acteur
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deletar(@PathVariable("id") Long id) {

		try {
			actorService.deleteActor(id);
		} catch (Exception e) {
			return returnErrorMessage(e.getMessage());
		}

		return ResponseEntity.noContent().build();
	}

	private ResponseEntity<?> returnErrorMessage(String message) {
		AjaxResponseBody errorResponse = new AjaxResponseBody();
		errorResponse.setMsg(message);
		return ResponseEntity.badRequest().body(errorResponse);
	}

}
