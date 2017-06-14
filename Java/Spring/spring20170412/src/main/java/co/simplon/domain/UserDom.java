package co.simplon.domain;

public class UserDom {
	private long id;
	private String nom;
	private String prenom;
	private String matricule;
	private String email;
	private String motDePasse;
	private long equipe_id;
	private long typeDroit_id;
	private long valideur_id;
	private long RH_id;
	private long compteur_id;

	public long getId() {
		return id;
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public String getMatricule() {
		return matricule;
	}

	public String getEmail() {
		return email;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public long getEquipe_id() {
		return equipe_id;
	}

	public long getTypeDroit_id() {
		return typeDroit_id;
	}

	public long getValideur_id() {
		return valideur_id;
	}

	public long getRH_id() {
		return RH_id;
	}

	public long getCompteur_id() {
		return compteur_id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setMotDePasse(String password) {
		this.motDePasse = password;
	}

	public void setEquipe_id(long equipe_id) {
		this.equipe_id = equipe_id;
	}

	public void setTypeDroit_id(long typeDroit_id) {
		this.typeDroit_id = typeDroit_id;
	}

	public void setValideur_id(long valideur_id) {
		this.valideur_id = valideur_id;
	}

	public void setRH_id(long rH_id) {
		RH_id = rH_id;
	}

	public void setCompteur_id(long compteur_id) {
		this.compteur_id = compteur_id;
	}
}
