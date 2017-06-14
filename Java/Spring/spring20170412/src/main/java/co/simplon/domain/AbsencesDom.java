package co.simplon.domain;

import java.sql.Date;

public class AbsencesDom {
	private int id;
	private Date debut;
	private Date fin;
	private int type;
	private int statut;

	public int getId() {
		return id;
	}

	public Date getDebut() {
		return debut;
	}

	public Date getFin() {
		return fin;
	}

	public int getType() {
		return type;
	}

	public int getStatut() {
		return statut;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setDebut(Date debut) {
		this.debut = debut;
	}

	public void setFin(Date fin) {
		this.fin = fin;
	}

	public void setType(int type) {
		this.type = type;
	}

	public void setStatut(int statut) {
		this.statut = statut;
	}

}
