var nbDigit = 12,
pasDErreur = true,
sousTotal = 0,
resultat = 0,
affichage = "0",
operateur = "";

function gererTouche(touche) {
	if (pasDErreur === true) {
		if ((touche != "." || affichage.indexOf(".") < 0) && (touche != "0" || affichage != "0" || sousTotal != 0)) {
			if (touche != "." && affichage == "0") {
				affichage = "";
			}
			affichage += touche;
			if (affichage.length < nbDigit) {
				AfficherLCD(affichage);
			}
		}
	}
}

function additionner() {
	if (pasDErreur === true) {
		afficherSousTotal();
		operateur = "+";
	}
}

function soustraire() {
	if (pasDErreur === true) {
		if (affichage == "0") {
			gererTouche("-");
		} else {
			afficherSousTotal();
			operateur = "-";
		}
	}
}

function multiplier() {
	if (pasDErreur === true) {
		afficherSousTotal();
		operateur = "*";
	}
}

function diviser() {
	if (pasDErreur === true) {
		afficherSousTotal();
		operateur = "/";
	}
}

function calculerRacine() {
	if (pasDErreur === true) {
		if (affichage>=0) {
			affichage = Math.sqrt(affichage);
		} else {
			affichage = "ERREUR";
			pasDErreur = "false";
		}
		AfficherLCD(affichage);
	}
}

function calculerCarre() {
	if (pasDErreur === true) {
		affichage = Math.pow(affichage, 2);
		AfficherLCD(affichage);
	}
}

function calculer() {
	if (pasDErreur === true) {
		afficherSousTotal();
		operateur = "";
	}
}

function afficherSousTotal() {
	if (sousTotal == 0) {
		sousTotal = parseFloat(affichage);
	} else {
		switch (operateur) {
			case "+":
			sousTotal += parseFloat(affichage);
			break;
			case "-":
			sousTotal -= parseFloat(affichage);
			break;
			case "*":
			sousTotal *= parseFloat(affichage);
			break;
			case "/":
			sousTotal /= parseFloat(affichage);
			break;
			// default:	affichage = "ERREUR !";
		}
	}
	operateur = "";
	affichage = "0";
	AfficherLCD(sousTotal);
}

function remettreAZero() {
	sousTotal = 0;
	resultat = 0;
	affichage = "0";
	operateur = "";
	AfficherLCD("0");
	pasDErreur = true;
}

function AfficherLCD(mot) {
	document.getElementById("lcd").innerHTML = ajusterNombreAAfficher(mot);
}

function ajusterNombreAAfficher(nombreAAfficher) {
	var indice = 0;
	var posIndice = 0;
	var indiceStr ="";
	var signEx = "";
	var lcd = nombreAAfficher.toString();

	posIndice = lcd.indexOf("e");
	if (posIndice < 0) {
		lcd = lcd.substr(0, nbDigit);
	} else {
		indiceStr = lcd.substr(posIndice + 1);
		if (Math.abs(indiceStr) < 100) {
			lcd = lcd.substr(0, posIndice - 1);
			lcd = lcd.substr(0, nbDigit - 1) + '<span class="indice">e' + indiceStr + '</span>';
		} else {
			if (indiceStr > 0) {
				pasDErreur = false;
				if (nombreAAfficher < 0) {
					lcd = "-Infinity";
				} else {
					lcd = "Infinity";
				}
			} else {
				lcd = "0";
			}
		}
	}
return lcd;
}
