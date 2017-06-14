package co.simplon.domain;

import java.util.List;

public class CalendrierDom {
	private int id;
	private String nom;
	private String prenom;
	private List<AbsencesDom> absences;
	
	public int getId() {
		return id;
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public List<AbsencesDom> getAbsences() {
		return absences;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public void setAbsences(List<AbsencesDom> absences) {
		this.absences = absences;
	}

}
