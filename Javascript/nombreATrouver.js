function Trouver(Nb, NbA) {
var Resultat = "";
if (Nb < NbA) {Resultat = "Trop bas !"}
if (Nb > NbA) {Resultat = "Trop haut !"}
if (Nb == NbA) {Resultat = "Trouvé !"}
return Resultat;
}

function Generer() {
  return Math.round(Math.random() * 10);
}

function main() {
  var NombreATrouver = Generer();
  var NTrouve = "";
  while (NTrouve != "Trouvé !") {
    NTrouve = Trouver(MonNombre, NombreATrouver);
    var MonNombre = prompt("Entrer un nombre entre 0 et 10 :");
    afficherLog(NTrouve);
    NTrouve = "Trouvé !";
  }
}
