var ListeNotes = [];
// Trouvé sur https://developer.mozilla.org/fr/docs/Web/JavaScript/Reference/Objets_globaux/Math/random
// On renvoie un nombre aléatoire entre une valeur min (incluse)
// et une valeur max (exclue)
// nbDec : Nombre de chiffres après la virgule
function getRandomArbitrary(min, max, nbDec) {
	return Math.round((Math.random() * (max - min) + min) * Math.pow(10, nbDec)) / Math.pow(10, nbDec);
}

function CreerTableauDeNotesAleatoires() {
	ListeNotes = [];
	for (i = 0; i < 20; i++) {
		NoteAleatoire=getRandomArbitrary(0, 20, 1);
		ListeNotes.push(NoteAleatoire);
	}
}

function formaterNote(laNote) {
	var note = "" + laNote;
	var point = note.indexOf(".");
	if (point < 0) {
		note += ".";
	}
		note = "0" + note + "00";
		point = note.indexOf(".");
		note = note.substr(point - 2, 2) + "," + note.substr(point + 1, 2);
	return note;
}

function AfficherLaListeDesNotes() {
	afficherLog();
	afficherLog("Liste des notes : ", "RAZ");
	for (i = 0; i < ListeNotes.length; i++) {
		afficherLog(formaterNote(ListeNotes[i]), " - ");
	}
}

function CalculerEtAfficherRapport() {
	var Moyenne = 0;
	var NoteMin = 20;
	var NoteMax = 0;
	var Somme = 0;
	var NombreDeNotes = 0;
	for (i = 0; i < ListeNotes.length; i++) {
		if (ListeNotes[i] < NoteMin) {
			NoteMin = ListeNotes[i];
		}
		if (ListeNotes[i] > NoteMax) {
			NoteMax = ListeNotes[i];
		}
		Somme += ListeNotes[i];
		NombreDeNotes++;
	}
	Moyenne = Math.round((Somme / NombreDeNotes)*100)/100;
	afficherLog();
	afficherLog("Rapport de notes : Moyenne = " + formaterNote(Moyenne) + "  -  Note minimale = " + formaterNote(NoteMin) + "  -  Note maximale = " + formaterNote(NoteMax));
  afficherLog();
}

function gererNotesEleve() {
	afficherTitre("Gestion des notes d'un élève");
	CreerTableauDeNotesAleatoires();
	AfficherLaListeDesNotes();
	CalculerEtAfficherRapport();
}
