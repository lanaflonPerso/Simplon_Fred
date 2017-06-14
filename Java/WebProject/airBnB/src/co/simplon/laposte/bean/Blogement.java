package co.simplon.laposte.bean;

public class Blogement {
	
	private String description;
	private String rue;
	private String code;
	private String ville;
	private String type;
	private int proprietaire_id;
	private int adresse_id;
	private int type_id;
	private int id;
	private String message;
	private boolean erreur;
	
	public String getDescription() {
		return description;
	}
	public String getRue() {
		return rue;
	}
	public String getCode() {
		return code;
	}
	public String getVille() {
		return ville;
	}
	public String getType() {
		return type;
	}
	public int getProprietaire_id() {
		return proprietaire_id;
	}
	public int getAdresse_id() {
		return adresse_id;
	}
	public int getType_id() {
		return type_id;
	}
	public int getId() {
		return id;
	}
	public String getMessage() {
		message = "";
		if (rue.length() <4) {message += " Rue invalide ";}
		if (code.length() <4) {message += " Code postal invalide ";}
		if (ville.length() <4) {message += " Ville invalide ";}
		return message;
	}
	public boolean isErreur() {
		if (message.length() > 0) {erreur = true;}
		return erreur;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setRue(String rue) {
		this.rue = rue;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setProprietaire_id(int proprietaire_id) {
		this.proprietaire_id = proprietaire_id;
	}
	public void setAdresse_id(int adresse_id) {
		this.adresse_id = adresse_id;
	}
	public void setType_id(int type_id) {
		this.type_id = type_id;
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
	

}
