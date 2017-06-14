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
import co.simplon.videomanager.domain.Category;
import co.simplon.videomanager.service.CategoryService;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

	@Autowired
	CategoryService categoryService;

	/**
	 * Liste des acteurs
	 * 
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> listCategorys(@RequestParam(value="search", defaultValue="") String search) {
		List<Category> listCategory;
		try {
			listCategory = categoryService.listCategorys(search);
		} catch (Exception e) {
			return returnErrorMessage(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(listCategory);
	}

	/**
	 * recherche d'un acteur. note : l'id est dans l'url et non en parametre
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getCategory(@PathVariable("id") Long id) {
		Category category = null;
		try {
			category = categoryService.getCategory(id);
		} catch (Exception e) {
			return returnErrorMessage(e.getMessage());
		}
		if (category == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(category);
	}

	/**
	 * creation d'un acteur
	 * 
	 * @param category
	 * @param errors
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> insertCategory(@Valid @RequestBody Category category, Errors errors) {

		// Si erreur de validation, retour erreur 400 (bad request), avec le
		// message d'erreur
		if (errors.hasErrors()) {
			String message = errors.getAllErrors().stream().map(x -> x.getDefaultMessage())
					.collect(Collectors.joining(","));
			return returnErrorMessage(message);
		}

		try {
			category = categoryService.insertCategory(category);
		} catch (Exception e) {
			return returnErrorMessage(e.getMessage());
		}

		return ResponseEntity.status(HttpStatus.OK).body(category);
	}

	/**
	 * 
	 * @param category
	 * @param errors
	 * @return
	 */
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<?> atualizar(@Valid @RequestBody Category category, Errors errors) {
		// Si erreur de validation, retour erreur 400 (bad request), avec le
		// message d'erreur
		if (errors.hasErrors()) {
			String message = errors.getAllErrors().stream().map(x -> x.getDefaultMessage())
					.collect(Collectors.joining(","));
			return returnErrorMessage(message);
		}

		try {
			categoryService.updateCategory(category);
		} catch (Exception e) {
			return returnErrorMessage(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(category);
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
			categoryService.deleteCategory(id);
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
