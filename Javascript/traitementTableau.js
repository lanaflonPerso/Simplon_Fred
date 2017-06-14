/********************************************************************************************/
/*                                                                                          */
/*  Déclaration des variables globales                                                      */
/*                                                                                          */
/********************************************************************************************/

// Déclaration de "mots", variable de type tableau.
var mots = ['bananas', 'apples', 'pears', 'avocados', 'john', 'david', 'omar', 'fred', 'idris', 'dog', 'monkey', 'elephant', 'kayak', 'angela'];


/* Fin de la section Déclaration de variables globales */



/********************************************************************************************/
/*                                                                                          */
/*  Ensemble des fonctions javascript                                                       */
/*                                                                                          */
/********************************************************************************************/

/* Fonction "ajouterEntete" affiche dans la console une entête annonçant un résultat.
    - Argument : "titre" facultatif de type Texte.
    - Valeur retournée : Booléen True.
    exemple : ajouterEntete("Liste des mots commençant par A"); */
function ajouterEntete(titre) {
	// Affiche 2 lignes vides.
	afficherLog();
	afficherLog();
	// Si présence de l'argument "titre", affiche le titre encadré.
	if (titre !== undefined) {
		afficherLog(" " + "-".repeat(titre.length + 4));
		afficherLog(" : " + titre + " :");
		afficherLog(" " + "-".repeat(titre.length + 4));
	}
	// Affiche une lignes vides.
	afficherLog();
	return true;
}

/* Fonction "trouverMotCommencantPar" affiche dans la console la liste des mots commençant par "lettre" passé en argument.
    - Argument : Variable Texte "lettre" correspondant à la première lettre recherchée.
    - Valeur retournée : Booléen True.
    exemple : trouverMotCommencantPar("a"); */
function trouverMotCommencantPar(lettre) {
	// Convertit l'argument "lettre" en minuscule.
	lettre = lettre.toLowerCase();
	// Affichage de l'entête annonçant la liste des mots commençant par "lettre" passé en argument.
	ajouterEntete("Liste des mots commençant par \"" + lettre + "\"");
	// Balayage du tableau "mots" et affichage des mots commençant par "lettre" passé en argument.
	for (var i = 0; i < mots.length; i++) {
		// Récupère la première lettre du mot "mots[i]", le convertit en minuscule et l'affecte à la variable "initial".
		var initial = mots[i].substr(0, 1).toLowerCase();
		// Si "initial" correspond à la première lettre recherchée, afficher le mot "mots[i]".
		if (initial == lettre) {
			afficherLog(mots[i]);
		}
	}
	return true;
}

/* Fonction "trouverMotCommencantParVoyelle" affiche dans la console la liste des mots commençant par une voyelle.
    - Argument : Aucun.
    - Valeur retournée : Booléen True.
    exemple : trouverMotCommencantParVoyelle(); */
function trouverMotCommencantParVoyelle() {
	// Déclaration de la variable Texte "voyelles" contenant la chaine de l'ensemble des voyelles.
	var voyelles = "aeiouy";
	// Affichage l'entête annonçant l'affichage du résultat.
	ajouterEntete("Liste des mots commençant par une voyelle");
	// Balayage du tableau à la recherche de la cible.
	for (var i = 0; i < mots.length; i++) {
		// Déclaration de la variable Texte "premLettre" contenant la première lettre du mot "mots[i]" convertit en minuscule.
		var premLettre = mots[i].substr(0, 1).toLowerCase();
		// Si "premLettre" est contenue dans "voyelles", afficher le mot "mots[i]".
		if (voyelles.indexOf(premLettre) >= 0) {
			afficherLog(mots[i]);
		}
	}
	return true;
}

/* Fonction "trouverMotsLongsEtCourts" balaye le tableau et retourne la liste des mots les plus courts et ceux es plus longs.
    - Argument : Aucun.
    - Valeur retournée : Booléen True.
    exemple : trouverMotsLongsEtCourts(); */
function trouverMotsLongsEtCourts() {
	// Déclaration des variables longueur mini et longueur maxi.
	var longueurMini = 100;
	var longueurMaxi = 0;
	// Balayage du tableau à la recherche de longueur mini et de longueur maxi.
	for (var i = 0; i < mots.length; i++) {
		if (mots[i].length < longueurMini) {
			longueurMini = mots[i].length;
		}
		if (mots[i].length > longueurMaxi) {
			longueurMaxi = mots[i].length;
		}
	}
	// Affichage de l'entête annonçant la liste des mots les plus courts.
	ajouterEntete("Liste des mots les plus courts");
	// Balayage du tableau et affichage des mots les plus courts.
	for (var i = 0; i < mots.length; i++) {
		if (mots[i].length == longueurMini) {
			afficherLog(mots[i]);
		}
	}
	// Affichage de l'entête annonçant la liste des mots les plus longs.
	ajouterEntete("Liste des mots les plus longs");
	// Balayage du tableau et affichage des mots les plus longs.
	for (var i = 0; i < mots.length; i++) {
		if (mots[i].length == longueurMaxi) {
			afficherLog(mots[i]);
		}
	}
	return true;
}


/* Fonction main exécutant un ensemble de fonctions.
    - Argument : Aucun.
    - Valeur retournée : Booléen True.
    exemple : main();

Opérations réalisées :
    - Afficher tous les mots commençant par la lettre "a".
		- Afficher tous les mots commençant par une voyelle.
		- Afficher les mots les plus courts de la liste "mots".
		- Afficher les mots les plus longs de la liste "mots". */
function main() {
	trouverMotCommencantPar("a");
	trouverMotCommencantParVoyelle();
	trouverMotsLongsEtCourts();
	ajouterEntete();
	return true;
}

/* Fin de la section Fonctions javascript */



/********************************************************************************************/
/*                                                                                          */
/*  Exécutions au démarrage de la page HTML                                                 */
/*                                                                                          */
/********************************************************************************************/

// Exécution de la fonction "main" au démarrage de la page HTML associée.
// main();
