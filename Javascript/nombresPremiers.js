function NbPremiers(Nb) {

	var topDepart = new Date().getTime();
	var delaiDExecution = 0;

	var listeDesNombresPremiers = [1, 2, 3];
	var nombreAVerifier1 = 0;
	var nombreAVerifier2 = 0;
	var nombreNonPremier1 = false;
	var nombreNonPremier2 = false;
	var nombreLimite = 1;

	afficherTitre("Liste des nombres premiers");
	afficherLog();
	afficherLog("Liste des nombres premiers inférieurs à " + Nb + " :");
	afficherLog();
	afficherLog("1", ", ");
	afficherLog("2", ", ");
	afficherLog("3", ", ");

	for (i = 1; i < Math.round((Nb + 5) / 6); i++) {
		nombreAVerifier1 = (6 * i) - 1;
		nombreAVerifier2 = (6 * i) + 1;
		nombreLimite=Math.sqrt(nombreAVerifier2);

		nombreNonPremier1 = false;
		nombreNonPremier2 = false;

		for (j = 1; j < (listeDesNombresPremiers.length); j++) {
			if (listeDesNombresPremiers[j]>nombreLimite) {
				break;
			}
			if (nombreNonPremier1 == false && (nombreAVerifier1 % listeDesNombresPremiers[j]) == 0) {
				nombreNonPremier1 = true;
			}
			if (nombreNonPremier2 == false && (nombreAVerifier2 % listeDesNombresPremiers[j]) == 0) {
				nombreNonPremier2 = true;
			}
			if (nombreNonPremier1 == true && nombreNonPremier2 == true) {
				break;
			}
		}
		if (nombreNonPremier1 == false) {
			listeDesNombresPremiers.push(nombreAVerifier1);
			if (nombreAVerifier1 <= Nb) {afficherLog("" + nombreAVerifier1, ", ");}
		}
		if (nombreNonPremier2 == false) {
			listeDesNombresPremiers.push(nombreAVerifier2);
			if (nombreAVerifier2 <= Nb) {afficherLog("" + nombreAVerifier2, ", ");}
		}
	}

	delaiDExecution = new Date().getTime() - topDepart;
	afficherLog();
	afficherLog();
	afficherLog("Durée d'exécution : " + (Math.round(delaiDExecution/10)/100) + " secondes.");
	afficherLog(listeDesNombresPremiers.length + " nombres premiers trouvés.");
	afficherLog();
	return true;
}

function trouverListeNbPremiers() {
	var nombre = parseInt(prompt("Entrer un nombre entier :"));
	NbPremiers(nombre);
}
