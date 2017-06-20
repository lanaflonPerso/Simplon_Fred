// Block exécuté au chargement
$(document).ready(function() {

	// Routine Ajax permettant d'exécuter une requête HTTP afin de récupérer des infos du Back en Json
	$.ajax({
		type: "GET",											// Type de requête
		url: "absence/listeAbsence",			// URL de la requête
		success: function(response) {			// Exécute le block si la réponse est satisfaite (code 200)
			listeAbsences = response; 			// Les données fournies sont stockées dans la variable listeAbsences
		}
	});
	// JS poursuit ses traitements même si le traitement Ajax n'est pas terminé.
	 
	// Le traitement Ajax étant asynchrone par rapport à JS, la routine ci-dessous permet d'exécuter le block
	// une fois la récupération des données est complète.
	$(document).ajaxStop(function () {
		afficherCalendrier();
		afficheLegend();
	});
	
	// Gestion du bouton gauche décalant d'un mois en arrière le calendrier.
	$('#leftcalendrier').click(function(){
		dateEnCours = new Date(annee, (mois - 1), 1); // Décalage d'un mois en arrière de la date de référence.
		afficherCalendrier();
	});
