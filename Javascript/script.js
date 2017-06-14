var premierLog = 0;
function afficherTitre(texte) {
  if ($("#titre").text() != texte) {viderAfficheur();}
  premierLog = 0;
  document.getElementById("titre").innerHTML = texte;
}
function afficherLog(texte = "", option = "") {
  if (option === "") {
    option = "<br>";
  } else {
    if (premierLog > 0) {
      var tempo = option;
      option = texte;
      texte = tempo;
    } else {
      if (option == "RAZ") {
        premierLog = 0;
      } else {
        premierLog = 1;
      }
      option = "";
    }
  }
  document.getElementById('console').insertAdjacentHTML('beforeend', texte + option);
}
function viderAfficheur() {
  $("#titre").empty();
  $("#console").empty();
}
