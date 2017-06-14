package co.simplon.videomanager.domain;

import java.sql.Timestamp;
import org.hibernate.validator.constraints.NotBlank;

public class Actor {
	
	private Long id;
	
	@NotBlank(message = "lastName can't empty!")
	private String lastName;

	@NotBlank(message = "lastName can't empty!")
	private String firstName;
	
	private Timestamp lastUpdate;
	
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
