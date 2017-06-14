package co.simplon.videomanager.service;

import java.sql.Timestamp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.simplon.videomanager.domain.Language;
import co.simplon.videomanager.repository.LanguageRepository;

/**
 * service gérant le langage.
 * 
 * @author simplon
 *
 */
@Service
public class LanguageService {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private LanguageRepository repo;

	public Iterable<Language> listLanguages() throws Exception {
		return repo.findAll();
		
	}

	public Language getLanguage(Long id) throws Exception {
		Language language = null;
		try {
			language = repo.findOne(id);
		} catch (Exception e) {
			log.error("Hibrnate Error !: getLanguage", e);
			throw e;
		}
		return language;
	}

	public Language insertLanguage(Language language) throws Exception {
		try {
			language.setId(new Long(0));
			language.setLastUpdate(new Timestamp(System.currentTimeMillis()));
			language = repo.save(language);
		} catch (Exception e) {
			log.error("Hibrnate Error !: insertLanguage", e);
			throw e;
		}
		return language;
	}

	public void updateLanguage(Language language) throws Exception {
		try {
			language.setLastUpdate(new Timestamp(System.currentTimeMillis()));
			repo.save(language);
		} catch (Exception e) {
			log.error("Hibrnate Error !: updateLanguage", e);
			throw e;
		}
	}

	public void deleteLanguage(Long id) throws Exception {
		try {
			repo.delete(id);
		} catch (Exception e) {
			log.error("Hibrnate Error !: deleteLanguage", e);
			throw e;
		}
	}

}
