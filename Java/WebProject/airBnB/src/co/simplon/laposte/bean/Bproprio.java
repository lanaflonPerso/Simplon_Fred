package co.simplon.laposte.bean;

public class Bproprio {
	
	private String nom;
	private String prenom;
	private String telephone;
	private String email;
	private int id;
	private String message;
	private boolean authentique;
	private boolean erreur;

	public String getNom() {
		return nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public String getTelephone() {
		return telephone;
	}
	public String getEmail() {
		return email;
	}
	public int getId() {
		return id;
	}
	public String getMessage() {
		String message = "";
		if (nom.length()<4) {message += " Nom invalide ";}
		if (prenom.length()<4) {message += " Prénom invalide ";}
		if (telephone.length()<4) {message += " Numéro de téléphone invalide ";}
		if (email.length()<4) {message += " Adresse mail invalide ";}
		return message;
	}
	public boolean isErreur() {
		if (message.length() > 0) {erreur = true;}
		return erreur;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void setErreur(boolean erreur) {
		this.erreur = erreur;
	}
	public boolean isAuthentique() {
		return authentique;
	}

}
