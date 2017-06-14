function AfficherFizzBuzz(nombre) {

  // *3 : fizz
  // *5 : buzz
  // *3*5 : fizzbuzz
  // othercase : Number

  var Resultat = nombre;
  if (nombre % 3 == 0) {Resultat = "fizz";}
  if (nombre % 5 == 0) {Resultat = "buzz";}
  if ((nombre % 3 == 0) && (nombre % 5 == 0)) {Resultat = "fizzbuzz"}
  return Resultat;
}

function bouclerFizzBuzz() {
  var nombre = parseInt(prompt("Entrer un nombre entier :"));
  afficherTitre("Boucle FizzBuzz");
	afficherLog();
	afficherLog("Boucle FizzBuzz sur les " + nombre + " premiers nombres :");
	afficherLog();
  for (i=1; i<=nombre; i++) {
  afficherLog(("0000" + i).substr(-4) + " ===> " + AfficherFizzBuzz(i));
  }
  afficherLog();
  return true;
}
