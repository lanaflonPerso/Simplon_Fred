package co.simplon.videomanager.domain;

import java.sql.Timestamp;
import org.hibernate.validator.constraints.NotBlank;

public class Category {
	
	private Long id;
	
	@NotBlank(message = "name can't empty!")
	private String name;
	
	private Timestamp lastUpdate;
	
	public Category() {
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
