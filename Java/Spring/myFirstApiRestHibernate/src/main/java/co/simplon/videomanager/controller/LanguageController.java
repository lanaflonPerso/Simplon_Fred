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
import co.simplon.videomanager.domain.Language;
import co.simplon.videomanager.service.LanguageService;

/**
 * Controleur REST de la classe Language
 * @author simplon
 *
 */
@RestController
@RequestMapping("/api/language")
public class LanguageController {

	@Autowired
	LanguageService languageService;

	/**
	 * Liste des langages
	 * @return liste des langages
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> listLanguages() {
		Iterable<Language> listLanguage;
		try {
			listLanguage = languageService.listLanguages();
		} catch (Exception e) {
			return AjaxResponseError.getErrorMessage(AjaxResponseError.ERROR_EXEC, e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(listLanguage);
	}

	/**
	 * recherche d'un language. 
	 * 
	 * @param id id
	 * @return un language
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getlanguage(@PathVariable("id") Long id) {
		Language language = null;
		try {
			language = languageService.getLanguage(id);
		} catch (Exception e) {
			return AjaxResponseError.getErrorMessage(AjaxResponseError.ERROR_EXEC, e.getMessage());
		}
		if (language == null) {
			return AjaxResponseError.getErrorMessage(AjaxResponseError.ERROR_NOT_FOUND, "Not found");
		}
		return ResponseEntity.status(HttpStatus.OK).body(language);
	}

	/**
	 * creation d'un langage
	 * 
	 * @param language langage
	 * @param errors : erreur de validation
	 * @return : réponse de la requête
	 */
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> insertLangage(@Valid @RequestBody Language language, Errors errors) {

		// Si erreur de validation, retour erreur 400 (bad request), avec le
		// message d'erreur
		if (errors.hasErrors()) {
			return AjaxResponseError.extractErrorWhenIncompletRequest(errors);
		}

		try {
			language = languageService.insertLanguage(language);
		} catch (Exception e) {
			return AjaxResponseError.getErrorMessage(AjaxResponseError.ERROR_EXEC, e.getMessage());
		}

		return ResponseEntity.status(HttpStatus.OK).body(language);
	}

	/**
	 * 
	 * @param language langage
	 * @param errors : erreurs de validation
	 * @return : réponse de la requête
	 */
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<?> updateLanguage(@Valid @RequestBody Language language, Errors errors) {
		// Si erreur de validation, retour erreur 400 (bad request), avec le
		// message d'erreur
		if (errors.hasErrors()) {
			return AjaxResponseError.extractErrorWhenIncompletRequest(errors);
		}

		try {
			languageService.updateLanguage(language);
		} catch (Exception e) {
			return AjaxResponseError.getErrorMessage(AjaxResponseError.ERROR_EXEC, e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(language);
	}

	/**
	 * suppression d'un langage
	 * 
	 * @param id id du langage
	 * @return : réponse de la requête sans contenu
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteLanguage(@PathVariable("id") Long id) {

		try {
			languageService.deleteLanguage(id);;
		} catch (Exception e) {
			return AjaxResponseError.getErrorMessage(AjaxResponseError.ERROR_EXEC, e.getMessage());
		}

		return ResponseEntity.noContent().build();
	}

	
}
