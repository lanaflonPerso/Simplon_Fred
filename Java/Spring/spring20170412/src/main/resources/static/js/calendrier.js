var ConfJoursReposHebdo = 96;
var dateEnCours = new Date();
var idUser = 12;
var users = [{id: 10, nom: "ARMAND", prenom: "Fulbert"}, {id: 11, nom: "CHAUMETTE", prenom: "Ernest"}, {id: 12, nom: "FARDET", prenom: "Gondran"}, {id: 13, nom: "FOURQUAY", prenom: "Anatole"}, {id: 14, nom: "URBAIN", prenom: "Gertrude"}];
var listeJoursFeries = [new Date(2017, 0, 1), new Date(2017, 3, 16), new Date(2017, 3, 17), new Date(2017, 4, 1), new Date(2017, 4, 8), new Date(2017, 4, 25), new Date(2017, 5, 4), new Date(2017, 5, 5), new Date(2017, 6, 14), new Date(2017, 7, 15), new Date(2017, 10, 1), new Date(2017, 10, 11), new Date(2017, 11, 25)];
var listeAbsences = [
	{id: 10, debut: "10/02/2017", fin: "10/02/2017", type: 2, statut: 1},
	{id: 10, debut: "24/02/2017", fin: "24/02/2017", type: 2, statut: 1},
	{id: 10, debut: "28/03/2017", fin: "30/03/2017", type: 3, statut: 1},
	{id: 10, debut: "20/04/2017", fin: "30/04/2017", type: 3, statut: 1},
	{id: 10, debut: "09/05/2017", fin: "01/06/2017", type: 1, statut: 0},
	{id: 10, debut: "02/06/2017", fin: "04/06/2017", type: 3, statut: 0},
	{id: 10, debut: "06/06/2017", fin: "09/06/2017", type: 1, statut: 0},
	{id: 11, debut: "02/01/2017", fin: "18/01/2017", type: 1, statut: 1},
	{id: 11, debut: "25/01/2017", fin: "26/01/2017", type: 4, statut: 1},
	{id: 11, debut: "05/02/2017", fin: "05/02/2017", type: 2, statut: 1},
	{id: 11, debut: "15/03/2017", fin: "30/03/2017", type: 1, statut: 1},
	{id: 11, debut: "09/04/2017", fin: "14/04/2017", type: 4, statut: 0},
	{id: 11, debut: "06/06/2017", fin: "09/06/2017", type: 1, statut: 1},
	{id: 11, debut: "12/06/2017", fin: "16/06/2017", type: 2, statut: 0},
	{id: 12, debut: "11/01/2017", fin: "12/01/2017", type: 3, statut: 1},
	{id: 12, debut: "22/01/2017", fin: "26/01/2017", type: 2, statut: 1},
	{id: 12, debut: "01/03/2017", fin: "22/03/2017", type: 1, statut: 1},
	{id: 12, debut: "24/04/2017", fin: "28/04/2017", type: 3, statut: 0},
	{id: 12, debut: "01/05/2017", fin: "22/05/2017", type: 1, statut: 0},
	{id: 12, debut: "02/06/2017", fin: "02/06/2017", type: 4, statut: 0},
	{id: 12, debut: "12/06/2017", fin: "16/06/2017", type: 2, statut: 1},
	{id: 12, debut: "17/06/2017", fin: "23/06/2017", type: 3, statut: 0},
	{id: 13, debut: "25/04/2017", fin: "07/05/2017", type: 1, statut: 1},
	{id: 13, debut: "17/06/2017", fin: "23/06/2017", type: 3, statut: 1},
	{id: 13, debut: "24/06/2017", fin: "30/06/2017", type: 4, statut: 0},
	{id: 14, debut: "24/06/2017", fin: "30/06/2017", type: 4, statut: 1}
];

var Jour = ["Di", "Lu", "Ma", "Me", "Je", "Ve", "Sa"];
var Mois = ["Janvier", "Février", "Mars", "Avril", "Mai", "Juin", "Juillet", "Août", "Septembre", "Octobre", "Novembre", "Décembre"];
var idCalendrierHtml    = "table";
var mois;
var annee;
var couleur = "normal";
var calendrierChoisi = false;

$(document).ready(function() {

	afficherUser();
	
	afficherCalendrier();

	$('#left').click(function(){
		dateEnCours = new Date(annee, (mois - 1), 1);
		afficherCalendrier();
	});

	$('#right').click(function(){
		dateEnCours = new Date(annee, (mois + 1), 1);
		afficherCalendrier();
	});

	$('#today').click(function(){
		dateEnCours = new Date();
		afficherCalendrier();
	});

	$('#perso').click(function(){
		calendrierChoisi = false;
		afficherCalendrier();
	});

	$('#equipe').click(function(){
		calendrierChoisi = true;
		afficherCalendrier();
	});

});

function afficherUser() {
	for (var i=0; i < users.length; i++) {
		if (users[i].id == idUser) {
			$('#nom').text(users[i].nom);
			$('#prenom').text(users[i].prenom);
		}
	}
}

function afficherCalendrier() {
	viderElement(idCalendrierHtml);
	if (calendrierChoisi) {calendrierGroupe();} else {calendrierPerso();}
}

function calendrierPerso() {
	var date  = dateEnCours.getDate();
	var MoisAffiche = [3];
	var html = "";
	couleur = "jaune";
	mois = dateEnCours.getMonth();
	annee = dateEnCours.getFullYear();
	MoisAffiche[0] = new Date(annee, (mois - 1), 1);
	MoisAffiche[1] = new Date(annee, mois, 1);
	MoisAffiche[2] = new Date(annee, (mois + 1), 1);

	html = '<tr>';
	html += '<td class="' + couleur + ' mois border" colspan=7>' + Mois[MoisAffiche[0].getMonth()] + ' ' + MoisAffiche[0].getFullYear() + '</td>';
	html += '<td class="' + couleur + ' mois border" colspan=7>' + Mois[MoisAffiche[1].getMonth()] + ' ' + MoisAffiche[1].getFullYear() + '</td>';
	html += '<td class="' + couleur + ' mois border" colspan=7>' + Mois[MoisAffiche[2].getMonth()] + ' ' + MoisAffiche[2].getFullYear() + '</td>';
	html += '</tr>';
	$(idCalendrierHtml).append(html);

	html = "<tr>";
	for (var moisAffiche = 0; moisAffiche < 3; moisAffiche++) {
		for (var i = 1; i <= 7; i++) {
			bord = " borderB"
			if (i == 1) {bord += " borderL";}
			if ((ConfJoursReposHebdo & Math.pow(2, (i - 1))) == Math.pow(2, (i - 1))) {couleur = "gris";} else {couleur = "jaune";}
			html+='<td class="' + couleur + bord + '">' + Jour[i % 7] + "</td>";
		}
	}
	html += "</tr>";
	$(idCalendrierHtml).append(html);

	for (var ligne = 0; ligne < 6; ligne++) {
		html = "<tr>";
		for (var moisAffiche = 0; moisAffiche < 3; moisAffiche++) {
			jourSemaine = MoisAffiche[moisAffiche].getDay();
			if (jourSemaine == 0) {jourSemaine = 7;}
			for (var jourAffiche = 1; jourAffiche <= 7; jourAffiche++) {
				couleur = "normal";
				dateAfficheeEnCours = new Date(annee, mois + moisAffiche - 1, (1 + jourAffiche + (ligne * 7) - jourSemaine));
				dateAffichee = '' + dateAfficheeEnCours.getDate();
//				if (couleurCase(dateAfficheeEnCours)) {couleur = "gris";}
				couleur = couleurCase(dateAfficheeEnCours, idUser);
				if (dateAfficheeEnCours.getMonth() == ((mois + moisAffiche + 11) % 12)) {
					police = " policeNormale"
					}
				else {
					if (couleur == "gris") {
						police = " policeClaire";
						} else {
						couleur = "normal";
						police = " policeEstompee;"}
					}
				bord = ""
				if (jourAffiche == 1) {bord += " borderL";}
				if (ligne == 5) {bord += " borderB";}
				html += '<td class="' + couleur + police + bord + '">'+dateAffichee+'</td>';
			}
		}
		html += "</tr>";
		$(idCalendrierHtml).append(html);
	}

}

function calendrierGroupe() {
	var date  = dateEnCours.getDate();
	var html = "";
	couleur = "jaune";
	mois = dateEnCours.getMonth();
	annee = dateEnCours.getFullYear();
	var debut = new Date(annee, mois, -6);
	var fin   = new Date(annee, (mois + 1), 7);

	html = "<tr><td class='" + couleur + " border mois' rowspan=4>Equipe</td></tr>";
	html += "<tr>";
	html += "<td class='" + couleur + " mois border' colspan=7>" + Mois[debut.getMonth()] + " " + debut.getFullYear() + "</td>";
	debut = new Date(annee, (mois + 1), 0);
	html += "<td class='" + couleur + " mois border' colspan=" + debut.getDate() + ">" + Mois[debut.getMonth()] + " " + debut.getFullYear() + "</td>";
	html += "<td class='" + couleur + " mois border' colspan=" + (7 + 31 - debut.getDate()) + ">" + Mois[fin.getMonth()] + " " + debut.getFullYear() + "</td>";
	html += "</tr>";
	$(idCalendrierHtml).append(html);

	fin   = new Date(annee, (mois + 1), (7 + 31 - debut.getDate()));
	debut = new Date(annee, mois, -6);
	html = "<tr>";
	for (; debut <= fin;) {
		bord = "";
		couleur = "jaune";
		if (debut.getDate() == 1) {bord = " borderL";}
//		if (couleurCase(debut)) {couleur = "gris";}
		couleur = couleurCase(debut, 0);
		html+='<td class="' + couleur + bord + '">' + Jour[debut.getDay()] + "</td>";
	    debut.setDate(debut.getDate() + 1);
	}
	html += "</tr>";
	$(idCalendrierHtml).append(html);

	debut = new Date(annee, mois, -6);
	html = "<tr>";
	for (; debut <= fin;) {
		bord = " borderB";
		couleur = "jaune";
		if (debut.getDate() == 1) {bord += " borderL";}
//		if (couleurCase(debut)) {couleur = "gris";}
		couleur = couleurCase(debut, 0);
		html += '<td class="' + couleur + bord + '">' + debut.getDate() + "</td>";
	    debut.setDate(debut.getDate() + 1);
	}
	html += "</tr>";
	$(idCalendrierHtml).append(html);

	for (var i = 0; i < users.length; i++) {
		html = '<tr><td class="bleuUser borderR">' + users[i].nom + " " + users[i].prenom + "</td>";
		debut = new Date(annee, mois, -6);
		id = users[i].id;
		for (; debut <= fin;) {
			bord = "";
			couleur = "normal";
			if (debut.getDate() == 1) {bord = " borderL";}
//			if (couleurCase(debut)) {couleur = "gris";}
			couleur = couleurCase(debut, id);
			html += '<td class="' + couleur + bord + '"></td>';
		    debut.setDate(debut.getDate() + 1);
		}
		html += "</tr>";
		$(idCalendrierHtml).append(html);
	}
}

function couleurCase(date, id) {
	var coulR = couleur;
	var listeCoulR = ["rouge", "bleu", "vert", "mauve"];
	var intensite = ["Estompe", ""];
	jour = date.getDay() - 1;
	if (jour < 0) {jour = 6;}
	if ((ConfJoursReposHebdo & Math.pow(2, jour)) == Math.pow(2, jour)) {return "gris";}
	for (var i = 0; i < listeJoursFeries.length; i++) {
		if (date.getDate() == listeJoursFeries[i].getDate() && date.getMonth() == listeJoursFeries[i].getMonth() && date.getFullYear() == listeJoursFeries[i].getFullYear()) {return "gris";}
	}
//	console.log(id);
	if (id > 0) {
		for (var i=0; i < listeAbsences.length; i++) {
			if (listeAbsences[i].id == id) {
	 			if (verifDates(date, listeAbsences[i].debut, listeAbsences[i].fin)) {
					coulR = listeCoulR[(listeAbsences[i].type - 1)] + intensite[listeAbsences[i].statut];
//					console.log(coulR + " - " + listeAbsences[i].type + " - " + listeCoulR[listeAbsences[i].type]+ " - " + intensite[listeAbsences[i].statut]);
				}
			}
		}
	}
	return coulR;
}

function verifDates(date, sDebut, sFin) {
	var resultat = false;
	
	arrDeb = sDebut.split("/");
	arrFin = sFin.split("/");
	
	debut =  new Date(arrDeb[2], arrDeb[1] - 1, arrDeb[0]);
	fin   =  new Date(arrFin[2], arrFin[1] - 1, arrFin[0]);
	
	if (date >= debut && date <= fin) {resultat = true;}

	return resultat;
}

/*  Fonction servant à vider de tous les éléments HTML le container associé à l'ID  */
function viderElement(id) {
  $(id).empty();  // Supprimer tous les éléments contenus dans le container lié à l'ID passé en argument.
  return true;
}
/***********************************************/


function getUserJS() {

//	var idActor = $("#id").val();

	$.ajax({
		type : "GET",
		contentType : "application/json",
		url : "/user/" + idUser,
		data : {},
		dataType : 'json',
		cache : false,
		timeout : 600000,
		success : function(data) {

			var json = "<h4>Ajax Response</h4><pre>"
					+ JSON.stringify(data, null, 4) + "</pre>";
//			$('#feedbackactor').html(json);
			$("#nom").val(data.nom);
			$("#prenom").val(data.prenom);
			console.log("SUCCESS : ", data);
//			button.prop("disabled", false);

		},
		error : function(e) {

			var json = "<h4>Ajax Response</h4><pre>" + e.responseText
					+ "</pre>";
//			$('#feedbackactor').html(json);

			console.log("ERROR : ", e);
//			button.prop("disabled", false);
		}
	});
}
