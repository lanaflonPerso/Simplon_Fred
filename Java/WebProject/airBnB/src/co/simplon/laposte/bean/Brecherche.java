package co.simplon.laposte.bean;

public class Brecherche {
	
	private String ville;
	private String debut;
	private String fin;
	private String message;
	private boolean erreur;
	
	public String getVille() {
		return ville;
	}
	public String getDebut() {
		return debut;
	}
	public String getFin() {
		return fin;
	}
	public String getMessage() {
		String message = "";
		if (debut.length()<4) {message += " Date de début invalide ";}
		if (fin.length()<4) {message += " Date de fin invalide ";}
		if (ville.length()<4) {message += " Ville invalide ";}
		return message;
	}
	public boolean isErreur() {
		if (message.length() > 0) {erreur = true;}
		return erreur;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public void setDebut(String debut) {
		this.debut = debut;
	}
	public void setFin(String fin) {
		this.fin = fin;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void setErreur(boolean erreur) {
		this.erreur = erreur;
	}

}
