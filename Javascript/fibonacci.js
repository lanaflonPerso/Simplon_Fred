function calculerSuite() {
	// var suite = "1, 2";
	var der1 = 1;
	var der2 = 2;
	var der0 = 0;
	var nombre = parseInt(prompt("Entrer un nombre entier :"));
	afficherTitre("Suite de Fibonacci");
	afficherLog();
	afficherLog("Liste des " + nombre + " premiers nombres de la suite de Fibonacci :");
	afficherLog();
	afficherLog("1, 2", ", ");
	for (i = 2; i < nombre; i++) {
		// suite += " " + (der1 + der2);
		der0 = der1 + der2;
		der1 = der2;
		der2 = der0;
		afficherLog(der0, ", ");
	}
	afficherLog();
	return true;
}
