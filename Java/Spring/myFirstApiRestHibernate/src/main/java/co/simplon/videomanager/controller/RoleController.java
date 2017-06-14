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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.common.AjaxResponseError;
import co.simplon.videomanager.domain.Role;
import co.simplon.videomanager.service.RoleService;

/**
 * Controleur REST de la classe Role
 * 
 * @author simplon
 *
 */
@RestController
@RequestMapping("/api/role")
public class RoleController {

	@Autowired
	RoleService roleService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> listActors(@RequestParam(value = "actor", defaultValue = "0") Long idActor,
			@RequestParam(value = "film", defaultValue = "0") Long idFilm) {
		Iterable<Role> listRole;
		try {
			if (idActor > 0)
				listRole = roleService.listFilms(idActor);
			else
				listRole = roleService.listActors(idFilm);
		} catch (Exception e) {
			return AjaxResponseError.getErrorMessage(AjaxResponseError.ERROR_EXEC, e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(listRole);
	}

	@RequestMapping(value = "/{idActor}/{idFilm}", method = RequestMethod.GET)
	public ResponseEntity<?> getRole(@PathVariable("idActor") Long idActor, @PathVariable("idFilm") Long idFilm) {
		Role role = null;
		try {
			role = roleService.getRole(idActor, idFilm);
		} catch (Exception e) {
			return AjaxResponseError.getErrorMessage(AjaxResponseError.ERROR_EXEC, e.getMessage());
		}
		if (role == null) {
			return AjaxResponseError.getErrorMessage(AjaxResponseError.ERROR_NOT_FOUND, "Not found");
		}
		return ResponseEntity.status(HttpStatus.OK).body(role);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> insertRole   (@Valid @RequestBody Role role, Errors errors) {
		if (errors.hasErrors()) {
			return AjaxResponseError.extractErrorWhenIncompletRequest(errors);
		}
		
		try {
			role = roleService.insertRole(role);
		} catch (Exception e) {
			return AjaxResponseError.getErrorMessage(AjaxResponseError.ERROR_EXEC, e.getMessage());
		}

		return ResponseEntity.status(HttpStatus.OK).body(role);
	}

	@RequestMapping(value = "/{idActor}/{idFilm}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteRole(@PathVariable("idActor") Long idActor, @PathVariable("idFilm") Long idFilm) {
		try {
			roleService.deleteRole(idActor, idFilm);
		} catch (Exception e) {
			return AjaxResponseError.getErrorMessage(AjaxResponseError.ERROR_EXEC, e.getMessage());
		}
		return ResponseEntity.noContent().build();
	}
}
