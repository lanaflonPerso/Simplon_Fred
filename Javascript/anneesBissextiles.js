function calculerSiBissextile(annee) {

	//     %4        : Année bissextile
	//   %100        : Année non bissextile
	//   %400        : Année bissextile
	//   Othercase   : non bissextile

	// var Resultat = "non bissextile";
	var Resultat = false;
	if (annee % 4 == 0) {
		// Resultat = "bissextile";
		Resultat = true;
	}
	if (annee % 100 == 0) {
		// Resultat = "non bissextile";
		Resultat = false;
	}
	if (annee % 400 == 0) {
		// Resultat = "bissextile";
		Resultat = true;
	}
	return Resultat;
}

function bouclerAnneeBissextile() {
	var compteur = 0;
  var annee1 = parseInt(prompt("Entrer année de début :"));
  var annee2 = parseInt(prompt("Entrer année de fin :"));
  var annee = annee1;
  var difference = Math.abs(annee2 - annee1);
  if (annee1 > annee2) {annee = annee2;}
  afficherTitre("Liste des années bissextiles");
	afficherLog();
	afficherLog("Liste des années bissextiles sur l'intervale de " + annee + " à " + (annee + difference) + " :");
	for (i = annee; i <= (annee + difference); i++) {
		if (calculerSiBissextile(i)) {
			afficherLog(("0000" + i).substr(-4),", ");
			compteur++;
		}
	}
	afficherLog();
	afficherLog();
	afficherLog("Total : " + compteur + " années bissextiles.");
  afficherLog();
  return true;
}
