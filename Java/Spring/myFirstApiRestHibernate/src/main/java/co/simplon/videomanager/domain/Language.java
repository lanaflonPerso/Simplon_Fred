package co.simplon.videomanager.domain;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

/**
 * entity Language
 */
@Entity
@Table(name = "language")
public class Language {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "language_id", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "name")
	@NotBlank(message = "name can't empty!")
	private String name;
	
	@Column(name = "last_update")
	private Timestamp lastUpdate;
	
	public Language() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Timestamp getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

}
