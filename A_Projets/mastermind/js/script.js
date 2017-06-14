/***********************************************
*      déclaration de variables globales       *
************************************************/
var ligneEnCours = 0;        // Indique le numéro de la ligne en cours lors des saisies.
var nbLignes = 0;            // Indique le nombre de ligne (d'essais) pour trouver la combinaison.
var nbColonnes = 0;          // Indique le nombre de couleurs à trouver.
var jeuPasEnCours = true;    // False quand le jeu démarre (A True, impossible de changer de grille).
var jeuTermine = false;      // Passe à true quand le jeu est terminé jusqu'à une nouvelle grille.
var presenceBouton = false;  // Signale la présence ou non du bouton Valider.
var ligneSaisie = [];        // Contient les couleurs saisies par le joueur.
var combinaison = [];        // Contient la combinaison de couleurs à trouver.
var trouvePlace = 0;         // Sert à compter le nombre de couleurs présentes et placées par rapport à la combinaison.
var trouveNonPlace = 0;      // Sert à compter le nombre de couleurs présentes sans être placées.
var lignesHTML = "";         // Variable string utilisée pour construire la grille et la palette.
/***********************************************/

/***********************************************
*        Appels de fonctions javascript        *
************************************************/

/*  Fonction initialisant l'affichage de la planche en fonction du niveau de difficulté choisi  */
function afficherPlanche(nb) {
  if (jeuPasEnCours || jeuTermine) {  // Réintialise le jeu si le jeu n'est pas en cours.
  ligneEnCours = 1;   //Initialise le numéro de ligne en cours.
  jeuTermine = false;      // Initialise les paramètres du jeu
  jeuPasEnCours = true;    //           ..
  presenceBouton = false;  //           ..
  nbColonnes = nb;
  nbLignes = parseInt(nbColonnes * 2.5);  // Définit le nombre de lignes en fonction de la difficulté choisie.
  afficherPalette();  // Affiche la palette.
  afficherGrille();  // Affiche la grile.
  genererCombinaison();  // Génère la combinaison à trouver.
  gererBouton();  // Gère la bouton Valider.
  afficherMessage("", false);
}
return true;
}
/***********************************************/

/*  Fonction générant la combinaison à trouver  */
function genererCombinaison() {
  for (i = 1; i <= nbColonnes; i++) {
    combinaison[i] = Math.round((Math.random() * 5 + 1));  // Génère un nombre entier aléatoire de 1 à 6.
    ligneSaisie[i] = 0;  // réinitialise le tableau de saisies.
  }
  return true;
}
/***********************************************/

/*  Fonction réalisant les opérations après appuie sur le bouton Valider  */
function validerLigne() {
  calculerResultat();  // Calcul le résultat.
  afficherResultat();  // Affiche le résultat.
  ligneEnCours++;  // Incrémente la ligne de saisie.
  for (i = 1; i <= nbColonnes; i++) {  // Réinitilise le tableau de la ligne de saisie.
    ligneSaisie[i] = 0;
  }
  if (trouvePlace == nbColonnes || ligneEnCours > nbLignes) {  // Si combinaison trouvée ou nombre max d'essai atteint :
  jeuTermine = true;
  afficherCombinaison();  // Affiche la combinaison.
  if (ligneEnCours > nbLignes) {  // Affiche un message en fonction de la situation de fin de partie.
    modifierContenuHTML("#resultat", "Perdu !");
    afficherMessage("Désolé, c'est perdu.", true);
  } else {
    modifierContenuHTML("#resultat", "Gagné !!!");
    afficherMessage("Bravo, vous avez gagné.", true);
  }
}
gererBouton();
return true;
}
/***********************************************/

/*  Fonction affichant un message en fin de jeu.  */
function afficherMessage(texte, trueOuFalse) {
  modifierContenuHTML("#message", texte);
  afficherElement("#message", trueOuFalse);
}
/***********************************************/

/*  Fonction affichant la combinaison à trouver  */
function afficherCombinaison() {
  for (i = 1; i <= nbColonnes; i++) {
    remplacerImage("p" + combinaison[i], "s" + i);  // Affiche la combinaison à trouver au dessus de la grille des résultats.
  }
  return true;
}
/***********************************************/

/*  Fonction calculant le nombre ds couleurs placées ou présentes  */
function calculerResultat() {
  trouvePlace = 0;
  trouveNonPlace = 0;
  var ligne = ligneSaisie;
  var combi = [];
  // var combi = combinaison;  // Réaffectation du tableau pour manipulation interagit sur le tableau d'origine. C'est la loose...
  for (i = 1; i <= nbColonnes; i++) {  // Affectation du tableau de combinaison à la variable tableau "combi".
  combi[i] = combinaison [i];
}
for (i = 1; i <= nbColonnes; i++) {  // Comptage du nombre de couleurs bien placée.
  if (ligneSaisie[i] == combi[i]) {
    trouvePlace++;
    ligneSaisie[i] = 0;  // Mise à 0 des couleurs trouvées et placées afin de ne pas être comptées dans les non placées.
    combi[i]=0;
  }
}
for (i = 1; i <= nbColonnes; i++) {  // Comptage de couleurs présentes et pas bien placées.
  for (j = 1; j <= nbColonnes; j++) {
    if (i != j && ligneSaisie[i] == combi[j] && combi[j] != 0) {
      trouveNonPlace++;
      ligneSaisie[i] = 0;  // Mise à 0 afin qu'il n'y ait pas un double comptage des couleurs présentes et non placées.
      combi[j] = 0;
    }
  }
}
return true;
}
/***********************************************/

/*  Fonction affichant les couleurs placées ou juste présentes  */
function afficherResultat() {
  for (i = 1; i <= trouvePlace; i++) {
    remplacerImage("r0", "r" + ligneEnCours + "c" + i);  // Ajoute une bille noire par couleur bien placée.
  }
  for (i = 1; i <= trouveNonPlace; i++) {
    remplacerImage("r1", "r" + ligneEnCours + "c" + (parseInt(i) + parseInt(trouvePlace)));  // Ajoute une bille blanche par couleur juste présente.
  }
  jeuPasEnCours = false;
  presenceBouton = false;
  return true;
}
/***********************************************/

/*  Fonction gérant l'activation du bouton Valider en fonction de la ligne de saisie  */
function gererBouton() {
  var saisieComplete = false;
  var compteur = 0;
  for (i = 1; i <= nbColonnes; i++) {  // Compte le nombre de couleurs présents dans la ligne de saisie.
    if (ligneSaisie[i] > 0) {
      compteur++;
    }
  }
  if (compteur == nbColonnes) {  // vérifie si la ligne de saisie est complète.
    saisieComplete = true;
  }
  if (presenceBouton) {
    activerElement("#bouton", saisieComplete);
  } else {
    if (ligneEnCours > 1) {
      viderElement('#b' + (ligneEnCours - 1));
    }
    incorporerHTML('#b' + ligneEnCours, '<button id="bouton" onclick="validerLigne()" disabled="disabled">Valider</button>');
    presenceBouton = true;
  }
  if (jeuTermine) {
    viderElement('#b' + ligneEnCours);
  }
  return true;
}
/***********************************************/

/*  Fonction permettant l'ajout de couleur sur double-click sur une couleur de la palette  */
function ajouterCouleurParDblClick(id) {
  if (!(jeuTermine)) {
    for (i = 1; i <= nbColonnes; i++) {
      if (ligneSaisie[i] == 0) {
        ligneSaisie[i] = extraireCouleur(id);  // Met à jour le tableau de saisie.
        remplacerImage(id, "l" + ligneEnCours + "c" + i);
        gererBouton();
        break;
      }
    }
  }
  return true;
}
/***********************************************/

/*  Fonction retournant le numéro correspondant à la couleur associée à l'ID qui est au format px ou rx  */
function extraireCouleur(id) {
  return id.substr(1);
}
/***********************************************/

/*  Fonction retournant le numéro de ligne à partir de l'ID qui est au format lxxcyy  */
function extraireLigne(id) {
  return id.substr(id.indexOf("l") + 1, id.indexOf("c") - 1);
}
/***********************************************/

/*  Fonction retournant le numéro de colonne à partir de l'ID qui est au format lxxcyy  */
function extraireColonne(id) {
  return id.substr(id.indexOf("c") + 1);
}
/***********************************************/


/***********************************************
*       Drag & Drop (trouvé sur le net)        *
************************************************
*  Utilisé sans la partie drop/remplacement    *
*  d'objet, modifié pour récup des 2 id        *
***********************************************/
function allowDrop(ev) {ev.preventDefault();  return true;}
function drag(ev) {ev.dataTransfer.setData("text", ev.target.id); return true;}
function drop(ev) {
  ev.preventDefault();
  var idSource = ev.dataTransfer.getData("text");
  var idDest = ev.target.getAttribute("id");
  if (idSource.indexOf("/") > -1) {
    idSource = idSource.substr(idSource.lastIndexOf("/") + 1);
    idSource = idSource.substr(0, idSource.indexOf("."));
  }
  if ((ligneEnCours == extraireLigne(idDest)) && (!(jeuTermine))) {  // Permet l'ajout uniquement sur la ligne en cours.
  remplacerImage(idSource, idDest);  // Remplacer l'image par la source.
  if (extraireCouleur(idSource) >= 0) {
    ligneSaisie[extraireColonne(idDest)] = extraireCouleur(idSource);  // Met à jour le tableau de saisie.
  }
  gererBouton();
}
return true;
}
/***********************************************/

/*  Fonction affichant la ligne contenant la palette ainsi que la zone prévue pour afficher la solution  */
function afficherPalette() {
  // Paramètres pr défaut de la palette.
  var id = "#palette";
  var classImg     = ' class="image" ';
  var classeDiv1   = ' class="row attributsGrille"';
  var classeDiv2   = ' class="col-md-5"';
  var classeDiv3   = ' class="col-md-2 text-right"';
  var classeDiv4   = ' class="col-md-5 text-right"';
  lignesHTML = "";
  viderElement(id);  // Supprimer l'ancienne palette.
  ajouterHTML('<div' + classeDiv1 + '>');
  ajouterHTML('<div' + classeDiv2 + '>');
  for (i = 0; i <= 6; i++) {
    ajouterHTML('<img' + classImg + ' src="images/p' + i + '.gif" id="p' + i + '" draggable="true" ondragstart="drag(event)" ondblclick="ajouterCouleurParDblClick(\'p' + i + '\')">');
  }
  ajouterHTML('</div>');
  ajouterHTML('<div id="resultat"' + classeDiv3 + '>');
  ajouterHTML('</div>');
  ajouterHTML('<div' + classeDiv4 + '>');
  for (i = 1; i <= nbColonnes; i++) {
    ajouterHTML('<img' + classImg + ' src="images/p0.gif" id="s' + i + '">');
  }
  ajouterHTML('</div>');
  ajouterHTML('</div>');
  incorporerHTML(id, lignesHTML);
  return true;
}
/***********************************************/

/*  Fonction permettant d'afficher la grille de saisies ainsi que la grille de réponse  */
function afficherGrille() {
  // Paramètres pr défaut de la grille.
  var id = "#planche";
  var classImg     = ' class="image" ';
  var classeDiv1   = ' class="row attributsGrille"';
  var classeDiv2   = ' class="col-md-5"';
  var classeDiv3   = ' class="col-md-2"';
  var classeDiv4   = ' class="col-md-5 text-right"';
  var classeDivS   = ' class="saisie"';
  var classeDivN   = ' class="noLigneSaisie"';
  lignesHTML = "";
  viderElement(id);  // Supprimer l'ancienne grille.
  for (i = 1; i <= nbLignes; i++) {
    ajouterHTML('<div' + classeDiv1 + '>');
    ajouterHTML('<div' + classeDiv2 + '>');
    ajouterHTML('<div' + classeDiv1 + '>');
    ajouterHTML('<div' + classeDivN + '>' + i + '</div>');
    ajouterHTML('<div' + classeDivS + '>');
    for (j = 1; j <= nbColonnes; j++) {
      ajouterHTML('<img' + classImg + ' src="images/p0.gif" id="l' + i + 'c' + j + '" ondrop="drop(event)" ondragover="allowDrop(event)">');
    }
    ajouterHTML('</div>');
    ajouterHTML('</div>');
    ajouterHTML('</div>');
    ajouterHTML('<div' + classeDiv3 + ' id="b' + i + '">');
    ajouterHTML('</div>');
    ajouterHTML('<div' + classeDiv4 + '>');
    for (j = 1; j <= nbColonnes; j++) {
      ajouterHTML('<img' + classImg + 'src="images/p0.gif" id="r' + i + 'c' + j + '">');
    }
    ajouterHTML('</div>');
    ajouterHTML('</div>');
  }
  incorporerHTML(id, lignesHTML);
  return true;
}
/***********************************************/



/***********************************************
*          Appels de fonctions jQuery          *
************************************************/

/*  Fonction permettant d'afficher ou de cacher le bouton Valider  */
function afficherElement(id, trueOrFalse) {
  if (trueOrFalse) {
    // True pour afficher et False pour cacher.
    $(id).show();  // Afficher l'élément asocié à l'ID.
  } else {
    $(id).hide();  // Cacher l'élément associé à l'ID.
  }
  return true;
}
/***********************************************/

/*  Fonction servant à vider de tous les éléments HTML le container associé à l'ID  */
function viderElement(id) {
  $(id).empty();  // Supprimer tous les éléments contenus dans le container lié à l'ID passé en argument.
  return true;
}
/***********************************************/

/*  Fonction permettant d'activer ou de désactiver l'élément HTML associé à l'ID.  */
function activerElement(id, trueOrFalse) {  // True pour activer et False pour désactiver.
  if (trueOrFalse) {
    $(id).removeAttr("disabled");  // Activer l'élément associé à l'ID.
  } else {
    $(id).attr("disabled", "disabled");  // Désactiver l'élément associé à l'ID.
  }
  return true;
}
/***********************************************/

/*  Fonction permettant le remplacement du texte de l'élément associé à l'ID par le texte passé en argument  */
function modifierContenuHTML(id, texte) {
  $(id).text(texte);  // Remplacer le texte de l'élément associé à l'ID par "texte" passé en argument.
  return true;
}
/***********************************************/

/*  Fonction ajoutant un élément HTML à "lignesHTML"  */
function ajouterHTML(html) {
  lignesHTML += html;
  return true;
}
/***********************************************/

/*  Fonction ajoutant un élément HTML "lignes" dans le container associé à l'ID  */
function incorporerHTML(id, lignes) {
  $(id).append(lignes);  // Ajouter un élément HTML "lignes" dans le container associé à l'ID.
  return true;
}
/***********************************************/

/*  Fonction modifiant la classe d'un élément HTML associé à l'ID  */
function modifierCSS(id, element, valeur) {
  $(id).css(element, valeur);
  return true;
}
/***********************************************/

/*  Fonction retournant la valeur de la classe d'un élément HTML associé à l'ID  */
function recupererValeurCSS(id, element) {
  return $(id).css(element);
}
/***********************************************/

/*  Fonction réalisant le remplacement de l'image de l'élément associé à l'ID de destination par celle de la source  */
function remplacerImage(source, destination) {
  $("#" + destination).attr("src", "images/" + source + ".gif");  // "destination" correspond à l'ID de l'élément recevant l'image, "source" est le nom du fichier image à insérer.
  $("#" + destination).attr("ondblclick", "ajouterCouleurParDblClick('" + source + "')");  // Ajout du traitement du double-click sur bille de la grille de saisie.
  return true;
}
/***********************************************/
