package co.simplon.videomanager.domain;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * entity Film note : les champs rating et special_features ne sont pas traites
 * dans cet exemple. ce sont des champs de type SET et ENUM que je deconseille
 * d'utiliser
 */
@Entity
@Table(name = "film")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class Film {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "film_id", unique = true, nullable = false)
	private Long id;

	@Column(name = "title")
	@NotBlank(message = "title can't empty!")
	private String title;

	@Column(name = "description")
	@NotBlank(message = "description can't empty!")
	private String description;

	@Column(name = "release_year")
	private Long releaseYear;

	@Column(name = "rental_duration")
	private Long rentalDuration;

	@Column(name = "rental_rate")
	private Double rentalRate;

	@Column(name = "length")
	private Long length;

	@Column(name = "replacement_cost")
	private Double replacementCost;

	@Column(name = "last_update")
	private Timestamp lastUpdate;

	@OneToOne(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private FilmText filmText;

	@ManyToOne
	@JoinColumn(name = "language_id")
	private Language language;

	@ManyToOne
	@JoinColumn(name = "original_language_id")
	private Language originalLanguage;

	/* Relation bidirectionnelle, le owner est Actor.
	 * On est en bidirectionnel, pour éviter une infinite loop en Json, on indique @JsonBackReference 
	 * */
	
	public Film() {
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

	public Long getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(Long releaseYear) {
		this.releaseYear = releaseYear;
	}

	public Long getRentalDuration() {
		return rentalDuration;
	}

	public void setRentalDuration(Long rentalDuration) {
		this.rentalDuration = rentalDuration;
	}

	public Double getRentalRate() {
		return rentalRate;
	}

	public void setRentalRate(Double rentalRate) {
		this.rentalRate = rentalRate;
	}

	public Long getLength() {
		return length;
	}

	public void setLength(Long length) {
		this.length = length;
	}

	public Double getReplacementCost() {
		return replacementCost;
	}

	public void setReplacementCost(Double replacementCost) {
		this.replacementCost = replacementCost;
	}

	public Timestamp getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public Language getOriginalLanguage() {
		return originalLanguage;
	}

	public void setOriginalLanguage(Language originalLanguage) {
		this.originalLanguage = originalLanguage;
	}

	public FilmText getFilmText() {
		return filmText;
	}

	public void setFilmText(FilmText filmText) {
		this.filmText = filmText;
	}
	
	

}
