package co.simplon.videomanager.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

/**
 * entity Film 
 */
@Entity
@Table(name = "film_text")
public class FilmText {
	
	/**
	 * id qui a la meme valeur que l'id de la table film
	 */
	@Id
	@Column(name = "film_id")
	private Long id;

	@Column(name = "title")
	@NotBlank(message = "title can't empty!")
	private String title;

	@Column(name = "description")
	@NotBlank(message = "description can't empty!")
	private String description;

	@OneToOne(mappedBy = "filmText")
	private Film film;

	public FilmText() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
