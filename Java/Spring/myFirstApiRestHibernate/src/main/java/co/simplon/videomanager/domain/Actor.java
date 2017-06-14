package co.simplon.videomanager.domain;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * entity Actor
 */
@Entity
@Table(name = "actor")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class Actor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "actor_id", unique = true, nullable = false)
	private Long id;

	// NotBlanck est un validateur d'hibernate
	// Il indique que la propriete lastName doit être renseigne
	@Column(name = "last_name")
	@NotBlank(message = "lastName can't empty!")
	private String lastName;

	@Column(name = "first_name")
	@NotBlank(message = "lastName can't empty!")
	private String firstName;

	@Column(name = "last_update")
	private Timestamp lastUpdate;

	/* relation bidirectionnelle
	 * le owner est Film. C'est donc ici qu'on décrit la relation
	 * On est en bidirectionnel, pour éviter une infinite loop en Json, on indique @JsonManagedReference
	 */
	
	public Actor() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Timestamp getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

}
