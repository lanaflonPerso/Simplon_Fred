package co.simplon.laposte.bean;

public class Bresa {

	private String debut;
	private String fin;
	private int logement_id;
	private int id;
	private String message;
	private boolean erreur;

	public String getDebut() {
		return debut;
	}
	public String getFin() {
		return fin;
	}
	public int getLogement_id() {
		return logement_id;
	}
	public int getId() {
		return id;
	}
	public String getMessage() {
		String message = "";
		if (debut.length()<4) {message += " Date de début invalide ";}
		if (fin.length()<4) {message += " Date de fin invalide ";}
		if (logement_id<1) {message += " Anomalie d'ID de logement ";}
		return message;
	}
	public boolean isErreur() {
		if (message.length() > 0) {erreur = true;}
		return erreur;
	}
	public void setDebut(String debut) {
		this.debut = debut;
	}
	public void setFin(String fin) {
		this.fin = fin;
	}
	public void setLogement_id(int logement_id) {
		this.logement_id = logement_id;
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
