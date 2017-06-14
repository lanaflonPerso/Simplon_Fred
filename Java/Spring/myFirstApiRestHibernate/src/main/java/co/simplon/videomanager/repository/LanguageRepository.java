package co.simplon.videomanager.repository;

import org.springframework.data.repository.CrudRepository;

import co.simplon.videomanager.domain.Language;

public interface LanguageRepository extends CrudRepository<Language, Long> {
	
}