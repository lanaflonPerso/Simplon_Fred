/* * * * * * * * * * * * * * *
* * * * * * * * * * * * * * *
* * YOUR CODE GOES HERE ! * *
* * * * * * * * * * * * * * *
* * * * * * * * * * * * * * */


/********************************************************************************************/
/*                                                                                          */
/*  Déclaration des variables globales                                                      */
/*                                                                                          */
/********************************************************************************************/

var MonTimer;                // Variable de type numérique définissant l'ID de la minuterie.
var MonTimerPause;           // Variable de type numérique définissant l'ID de la minuterie de la pause.
var timerEtat = "stop";      // Variable de type texte gérant les 3 états possibles de la minuterie, play, pause ou stop.
var dureeTache = 25 * 60;    // Variable de type numérique définissant la durée d'une tâche (en secondes).
var dureePause1 = 5 * 60;    // Variable de type numérique définissant la durée d'une pause courte (en secondes).
var dureePause4 = 15 * 60;   // Variable de type numérique définissant la durée d'une pause longue (en secondes).
var timerClock = dureeTache; // Variable de type numérique gérant les secondes restantes de la minuterie.
var compteurTache = 0;       // Variable de type numérique comptabilisant le nombre de tâches terminées.
var cptKeyPress = 0;         // Variable de type numérique utilisé pour empêcher les évenements parasites sur touches appuyées.

/* Fin de la section Déclaration de variables globales */



/********************************************************************************************/
/*                                                                                          */
/*  Ensemble des fonctions javascript                                                       */
/*                                                                                          */
/********************************************************************************************/

/* Fonction playClick permet, si une tache est saisie et si la minuterie n'est pas active, de positionner timerEtat à play et d'activer la minuterie.
    - Argument : Aucun.
    - Valeur retournée : Booléen True.
    exemple : playClick(); */
function playClick() {
  if (recupTacheSaisie() != "" && timerEtat != "play") {
    timerEtat = "play";
    activerTimer();
  }
  return true;
}

/* Fonction pauseClick permet de positionner timerEtat à pause et de désactiver la minuterie.
    - Argument : Aucun.
    - Valeur retournée : Booléen True.
    exemple : pauseClick(); */
function pauseClick() {
  timerEtat = "pause";
  desactiverTimer();
  return true;
}

/* Fonction stopClick permet de positionner timerEtat à false et de désactiver la minuterie.
    - Argument : Aucun.
    - Valeur retournée : Booléen True.
    exemple : stopClick(); */
function stopClick() {
  timerEtat = "stop";
  desactiverTimer();
  return true;
}

/* Fonction afficherTimer permet d'afficher la minuterie.
    - Argument : Aucun.
    - Valeur retournée : Booléen True.
    exemple : afficherTimer();

    Opérations réalisées :
        - Convertir les secondes au format mm:ss.
        - Afficher la minuterie. */
function afficherTimer() {
  sec = ("0" + (timerClock % 60)).substr(-2);
  min = ("0" + (Math.floor(timerClock / 60))).substr(-2);
  afficherTimerjQuery(min + ":" + sec);
  return true;
}

/* Fonction activerTimer permet d'activer la minuterie.
    - Argument : Aucun.
    - Valeur retournée : Booléen True.
    exemple : activerTimer();

    Opérations réalisées :
        - Démarrer la minuterie décrémentant et affichant timerClock toutes les secondes.
        - Désactiver le champs de saisie des tâches.
        - En cas de dépassement du délai, exécution de desactiverTimer. */
function activerTimer() {
  modifierTitre('#tdoing', "Doing : Tâche en cours...");
  MonTimer = window.setInterval(function() {
    timerClock--;
    afficherTimer();
    if (timerClock <= 0) {
      timerEtat = "stop";
      desactiverTimer();
    }
  }, 1000);
  activerSaisieTache(False);
return true;
}


/* Fonction desactiverTimer permet d'activer la minuterie.
    - Argument : Aucun.
    - Valeur retournée : Booléen True.
    exemple : desactiverTimer();

    Opérations réalisées :
        - Arrêter la minuterie.
        - Si timerEtat vaut Stop, archiver la tâche. */
function desactiverTimer() {
  window.clearInterval(MonTimer);
  if (timerEtat == "stop" && recupTacheSaisie() != "") {
    archiverTache();
  }
  return true;
}


/* Fonction activerTimerPause permet d'activer la minuterie de la pause.
    - Argument : Aucun.
    - Valeur retournée : Booléen True.
    exemple : activerTimerPause();

    Opérations réalisées :
        - Démarrer la minuterie décrémentant et affichant timerClock toutes les secondes.
        - En cas de dépassement du délai :
              * Désactivation du timer.
              * Réactivation des boutons et du champs de saisie des tâches.
              * Réinitialisation de la durée du timer à la durée d'une tâche. */
function activerTimerPause() {
  MonTimerPause = window.setInterval(function() {
    timerClock--;
    afficherTimer();
    if (timerClock <= 0) {
      // window.clearInterval(MonTimer);
      window.clearInterval(MonTimerPause);
      bloquerTout(false);
      timerClock = dureeTache;
      modifierTitre('#tdoing', "Doing : Saisir tâche.");
      afficherTimer();
    }
  }, 1000);
  return true;
}

/* Fonction archiverTache permet un ensemble d'opérations faisant suite à la clôture d'une tâche.
    - Argument : Aucun.
    - Valeur retournée : Booléen True.
    exemple : archiverTache();

Opérations réalisées :
    - Incrémenter le compteur de tâches.
    - Archiver la tâche.
    - Afficher le compteur de tâche dans le titre Done.
    - Activer une pause longue toutes les 4 archives sinon activer une pause courte
    - Désactiver les boutons et la saisie des tâches */
function archiverTache() {
  var typePause = "";
  compteurTache++;
  if (compteurTache % 4 == 0) {
    timerClock = dureePause4;
    typePause = "Pause longue";
  } else {
    timerClock = dureePause1;
    typePause = "Pause courte";
  }
  afficherTimer();
  if (compteurTache < 4) {
    comblerArchiveTache(recupTacheSaisie());
  } else {
    ajouterArchiveTache(recupTacheSaisie());
  }
  modifierTacheSaisie("");
  modifierTitre("#tdone", "Done : " + compteurTache.toString());
  modifierTitre('#tdoing', typePause + " en cours...");
  bloquerTout(true);
  activerTimerPause();
  cptKeyPress = 0;
return true;
}

/* Fonction comblerArchiveTache permet un ensemble d'opérations visant à combler la liste de tâches existantes.
    - Argument : String texteAAfficher étant la tâche à archiver.
    - Valeur retournée : Booléen True.
    exemple : comblerArchiveTache("Restitution challenge");

Opérations réalisées :
    - Comblement des 3 premiers champs présents au démarrage dans la listes des tâches effectuées.
    - Hiérarchisation de haut en bas, du plus récents au plus anciens. */
function comblerArchiveTache(texteAAfficher) {
  modifierArchiveTache(recupererArchiveTache(2), 3);
  modifierArchiveTache(recupererArchiveTache(1), 2);
  modifierArchiveTache(texteAAfficher, 1);
  return true;
}

/* Fonction gererEntreePressee permet gérer l'évenement touche Entrée appuyée.
    - Argument : Aucun.
    - Valeur retournée : Booléen True.
    exemple : gererEntreePressee();

Opérations réalisées :
    - Exécute playClick. */
function gererEntreePressee() {
  playClick();
  return true;
}

/* Fin de la section Fonctions javascript */



/********************************************************************************************/
/*                                                                                          */
/*  Ensemble des appels jQuery                                                              */
/*                                                                                          */
/********************************************************************************************/

/* Fonction afficherTimerjQuery permet d'afficher la minuterie sur la page HTML.
    - Paramètre String tempsAAfficher correspondant au temps à afficher (format attendu "mm:ss").
    - Valeur retournée : Booléen True.
    exemple : afficherTimerjQuery("12:55"); */
function afficherTimerjQuery(tempsAAfficher) {
  $(".time").text(tempsAAfficher);
  return true;
}

/* Fonction ajouterArchiveTache permet d'ajouter la tâche achevée au dessus de la liste "Done" dans la page HTML.
    - Argument : String texteAAfficher correspondant à la tâche à archiver dans la liste Done.
    - Valeur retournée : Booléen True.
    exemple : ajouterArchiveTache("Restitution challenge"); */
function ajouterArchiveTache(texteAAfficher) {
  $("#done").prepend("<li class=\"list-group-item\"><s>" + texteAAfficher + "</s></li>");
  return true;
}

/* Fonction modifierArchiveTache permet de modifier une tâche achevée dans la grille existante de la liste "Done".
    - Argument : String texteAAfficher correspondant à la tâche à archiver dans la liste Done.
               : Numérique pos orrespond au rang dans la grille existante.
    - Valeur retournée : Booléen True.
    exemple : comblerArchiveTache("Restitution challenge", 2); Inscrit Restitution challenge à la deuxième ligne de la liste */
function modifierArchiveTache(texteAAfficher, pos) {
  $("li:nth-child(" + pos + ")").text(texteAAfficher).css("text-decoration", "line-through");
  return true;
}

/* Fonction recupererArchiveTache permet de récupérer le texte d'une tâche archivée de la liste "Done".
    - Argument : String texteAAfficher correspondant à la tâche à archiver dans la liste Done.
               : Numérique pos orrespond au rang dans la grille existante.
    - Valeur retournée : Valeur string  correspondant au texte de la tâche archivée en position pos.
    exemple : recupererArchiveTache(2); retourne le texte de la tâche archivée en position pos de la liste */
function recupererArchiveTache(pos) {
  return $("li:nth-child(" + pos + ")").text();
}

/* Fonction modifierTitre permet de modifier le titre correspondant à l'ID dans la page HTML.
    - Argument : String texteAAfficher correspondant au texte à inscrire dans l'élément lié à l'ID.
    - Valeur retournée : Booléen True.
    exemple : modifierTitre("#Done", "5 tâches effectuées."); */
function modifierTitre(id, texteAAfficher) {
  $(id).text(texteAAfficher);
  return true;
}

/* Fonction recupTacheSaisie permet de récupérer la tâche saisie dans la page HTML.
    - Argument : aucun.
    - Valeur retournée : String de la tâche en cours, c'est-à-dire la valeur contenu de le l'objet "task".
    exemple : ajouterArchiveTache("Restitution challenge"); */
function recupTacheSaisie() {
  return $('#task').val();
}

/* Fonction modifierTacheSaisie permet de modifier la tâche saisie dans la page HTML.
    - Argument : String texteAAfficher correspondant au texte à afficher.
    - Valeur retournée : Booléen True.
    exemple : modifierTacheSaisie("Veille technologique"); */
function modifierTacheSaisie(texteAAfficher) {
  $('#task').val(texteAAfficher);
  return true;
}

/* Fonction bloquerTout permet de verrouiller ou de déverrouiller l'ensemble champs de saisie et boutons de la page HTML.
    - Argument : Booléen trueOuFalse où True sert à verrouiller et false à déverrouiller.
    - Valeur retournée : Booléen True.
    exemple : bloquerTout(true); */
function bloquerTout(trueOuFalse) {
  if (trueOuFalse) {
    $('#task').attr("disabled", "disabled");
    $('.btn btn-default btn-lg').attr("disabled", "disabled");
  } else {
    $('#task').removeAttr("disabled");
    $('.btn btn-default btn-lg').removeAttr("disabled");
  }
  return true;
}

/* Fonction activerSaisieTache permet d'activer ou de désactiver la saisie dans le champs de saisie des tâches de la page HTML.
Lorsque le champs de saisie de la tâche est désactivée, le texte saisie apparait en rouge et en gras sinon le texte apparait en noir et en normal.
    - Argument : Booléen trueOuFalse où True sert à activer et false à désactiver.
    - Valeur retournée : Booléen True.
    exemple : activerSaisieTache(true); */
function activerSaisieTache(trueOuFalse) {
  if (trueOuFalse) {
    $('#task').removeAttr("disabled");
    $('#task').css("color","black");
    $('#task').css("font-weight","normal");
  } else {
    $('#task').attr("disabled", "disabled");
    $('#task').css("color","red");
    $('#task').css("font-weight","bolder");
  }
  return true;
}

/* Fin de la section Appels jQuery */



/********************************************************************************************/
/*                                                                                          */
/*  Exécutions au démarrage de la page HTML                                                 */
/*                                                                                          */
/********************************************************************************************/

/* Fonctions exécutées au démarrage.
  - Affichage du temps de la minuterie initialisée.
  - Affiche "Doing : Saisir tâche." en remplacement du simple "Doing". */
afficherTimer();
modifierTitre('#tdoing', "Doing : Saisir tâche.");
// modifierArchiveTache("", 1);
// modifierArchiveTache("", 2);
// modifierArchiveTache("", 3);


/* Fonctions déclarées au chargement de la page HTML.
Déclenche l'exécution de fonctions javascript sur l'évenement click sur les boutons de la page HTML.
  - playClick est exécuté après l'évenement click sur le bouton Play.
  - pauseClick est exécuté après l'évenement click sur le bouton Pause.
  - stopClick est exécuté après l'évenement click sur le bouton Stop.
  - gererEntreePressee est exécuté après l'évenement Entrée dans le champs de texte de saisie des tâches. */
$(document).ready(function() {
  $("#play").click(playClick);
  $("#pause").click(pauseClick);
  $("#stop").click(stopClick);
  $('#task').keypress(function(event) {
  	var touchePressee = (event.keyCode ? event.keyCode : event.which);
  	if(touchePressee == '13') {
      event.preventDefault();
      cptKeyPress++;
  		if (cptKeyPress == 1) {
        gererEntreePressee();
      }
  	};
  });
  // $(":disabled").css("background-color", "red");
});

/* Fin de la section Exécutions au démarrage */
