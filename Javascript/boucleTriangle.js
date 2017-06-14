function composerLigne(nombre, caractere) {
  var mot = "";
  for (j = 1; j <= nombre; j++) {
    mot += caractere;
  }
  return ("0000" + nombre).substr(-4) + " - " + mot;
}

function construire(nombre, caractere, sens) {
  var motSens = " croissant";
  if (sens === 1) {
    motSens = " décroissant";
  }
  afficherLog();
  afficherLog('Vous avez choisi un triangle' + motSens + ' de ' + nombre + ' lignes contenant des "' + caractere);
  afficherLog();
  if (sens === 1) {
    for (i = nombre; i > 0; i--) {
      afficherLog(composerLigne(i, caractere));
    }
  } else {
    for (i = 1; i < nombre + 1; i++) {
      afficherLog(composerLigne(i, caractere));
    }
  }
  return true;
}

function construireTriangle() {
  var nombre = parseInt(prompt("Entrer un nombre entier :"));
  var caractere = prompt("Entrer le caractère :");
  var sens = parseInt(prompt("Entrer le sens (1 pour décroissant) :"));
  afficherTitre("Boucle réalisant un triangle");
  construire(nombre, caractere, sens);
  afficherLog();
  return true;
}
