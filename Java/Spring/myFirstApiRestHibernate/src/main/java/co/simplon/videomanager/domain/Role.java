package co.simplon.videomanager.domain;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * entity Role (table film_actor)
 */

@Entity
@Table(name = "film_actor")

public class Role {

	@EmbeddedId
	private RolePK pk;

	@Column(name = "last_update")
	private Timestamp lastUpdate;

	public RolePK getPk() {
		return pk;
	}

	public void setPk(RolePK pk) {
		this.pk = pk;
	}

	public Timestamp getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

}
