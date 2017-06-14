var selectElementsStartingWithA = function(array) {
	var tablo = [];
	for (i = 0; i < array.length; i++) {
		if (array[i].substr(0, 1) == "a") {
			tablo.push(array[i]);
		}
	}
	return tablo;
}

var selectElementsStartingWithVowel = function(array) {
	var tablo = [];
	var voyelles = "aeiouy";
	for (var i = 0; i < array.length; i++) {
		var premLettre = array[i].substr(0, 1);
		if (voyelles.indexOf(premLettre) >= 0) {
			tablo.push(array[i]);
		}
	}
	return tablo;
}

var removeNullElements = function(array) {
	var tablo = [];
	for (i = 0; i < array.length; i++) {
		if (array[i] !== null) {
			tablo.push(array[i]);
		}
	}
	return tablo;
}

var removeNullAndFalseElements = function(array) {
	var tablo = [];
	for (i = 0; i < array.length; i++) {
		if (array[i] !== null && array[i] !== false) {
			tablo.push(array[i]);
		}
	}
	return tablo;
}

var reverseWordsInArray = function(array) {
	var tablo = [];
	var splitWord = "";
	for (i = 0; i < array.length; i++) {
		var splitWord = array[i].split("");
		var wordSplit = splitWord.reverse();
		tablo.push(wordSplit.join(""));
	}
	return tablo;
}

var everyPossiblePair = function(array) {
	var tablo = [];
	var array = array.sort();
	for (i = 0; i < array.length - 1; i++) {
		for (j = i + 1; j < array.length; j++) {
			var tablo2 = [];
			tablo2.push(array[i]);
			tablo2.push(array[j]);
			tablo.push(tablo2);
		}
	}
	return tablo;
}

var allElementsExceptFirstThree = function(array) {
	var tablo = [];
	for (i = 3; i < array.length; i++) {
		tablo.push(array[i]);
	}
	return tablo;
}

var addElementToBeginning = function(array, element) {
	array.unshift(element);
	return array;
}

var sortByLastLetter = function(array) {
	var tablo = reverseWordsInArray(array);
	tablo = tablo.sort();
	tablo = reverseWordsInArray(tablo);
	return tablo;
}

var getFirstHalf = function(string) {
	return string.substr(0, Math.round(string.length / 2));
}

var makeNegative = function(number) {
	return -Math.abs(number);
}

var numberOfPalindromes = function(array) {
	var tablo = reverseWordsInArray(array);
	var NbPalin = 0;
	for (i = 0; i < tablo.length; i++) {
		if (array[i] == tablo[i]) {
			NbPalin++;
		}
	}
	return NbPalin;
}

var shortestWord = function(array) {
	var NbMin = 200;
	var MiniMot = "";
	for (i = 0; i < array.length; i++) {
		if (array[i].length < NbMin) {
			NbMin = array[i].length;
			MiniMot = array[i];
		}
	}
	return MiniMot;
}

var longestWord = function(array) {
	var NbMax = 0;
	var MaxiMot = "";
	for (i = 0; i < array.length; i++) {
		if (array[i].length > NbMax) {
			NbMax = array[i].length;
			MaxiMot = array[i];
		}
	}
	return MaxiMot;
}

var sumNumbers = function(array) {
	var Somme = 0;
	for (i = 0; i < array.length; i++) {
		Somme += array[i];
	}
	return Somme;
}

var repeatElements = function(array) {
	return array.concat(array);
}

var stringToNumber = function(string) {
	return parseInt(string);
}

var calculateAverage = function(array) {
	var Somme = 0;
	for (i = 0; i < array.length; i++) {
		Somme += array[i];
	}
	return Somme / array.length;
}

var getElementsUntilGreaterThanFive = function(array) {
	var tablo = [];
	for (i = 0; i < 6; i++) {
		tablo.push(array[i]);
	}
	return tablo;
}

var convertArrayToObject = function(array) {
	var objet = {};
	var tablo1 = [];
	var tablo2 = [];
	var bascule = true;
	for (i = 0; i < array.length; ++i) {
		if (bascule) {
			tablo1.push(array[i]);
		} else {
			tablo2.push(array[i]);
		}
		bascule = !bascule;
	}
	for (i = 0; i < tablo1.length; ++i) {
		objet[tablo1[i]] = tablo2[i];
	}
	return objet;
}

var getAllLetters = function(array) {
	var tablo = [];
	var mot = "";
	for (i = 0; i < array.length; i++) {
		for (j = 0; j < array[i].length; j++) {
			var lettre = array[i].substr(j, 1),
				present = false;
			if (mot.indexOf(lettre) < 0) {
				mot += lettre;
				tablo.push(lettre);
			}
		}
	}
	return tablo.sort();
}

var swapKeysAndValues = function(object) {
	var obj = {};
	Object.getOwnPropertyNames(object).forEach(function(val) {
		obj[object[val]] = val;
	});
	return obj;
}

var sumKeysAndValues = function(object) {
	var somme = 0;
	Object.getOwnPropertyNames(object).forEach(function(val) {
		somme += parseInt(object[val]);
		somme += parseInt(val);
	});
	return somme;
}

var removeCapitals = function(string) {
	var mot = "";
	var lettre = "";
	for (var i = 0; i < string.length; i++) {
		lettre = string.substr(i, 1);
		if (lettre != lettre.toUpperCase() || lettre === " ") {
			mot += lettre;
		}
	}
	return mot;
}

var roundUp = function(number) {
	return Math.ceil(number);
}

var formatDateNicely = function(date) {
	var jour = '' + date.getDate(),
		mois = '' + (date.getMonth() + 1),
		annee = date.getFullYear();
	jour = ('0' + jour).substr(-2);
	mois = ('0' + mois).substr(-2);
	annee = ('20' + annee).substr(-4);
	return [jour, mois, annee].join('/');
}

var getDomainName = function(string) {
	var arobase = -1;
	var derPoint = -1;
	var res = "";
	arobase = string.lastIndexOf("@");
	derPoint = string.lastIndexOf(".");
	if ((arobase >= 0) && (derPoint >= 0) && (derPoint > arobase)) {
		res = string.substr(arobase + 1, derPoint - arobase - 1);
	} else {
		res = string + " incompatible !";
	}
	return res;
}

var titleize = function(string) {
	var mots = string.split(" "),
		mot = "",
		espace = "",
		ucase = true;
	for (i = 0; i < mots.length; i++) {
		if (ucase || (mots[i] !== "and" && mots[i] !== "the")) {
			mots[i] = mots[i].substr(0, 1).toUpperCase() + mots[i].substr(1);
			ucase = false;
		}
		if (mots[i].substr(-1) == ".") {
			ucase = true;
		}
		mot += espace + mots[i];
		espace = " ";
	}
	return mot;
}

var checkForSpecialCharacters = function(string) {
	var res = false;
	var caractere = "";
	var lettres = " éèàùçäâëêïîöôüû";
	for (i = 0; i < string.length; i++) {
		caractere = string.substr(i, 1).toLowerCase();
		if ((caractere < "0" || caractere > "9") && (caractere < "a" || caractere > "z") && (lettres.indexOf(caractere) < 0)) {
			res = true;
			break;
		}
	}
	return res;
}

var squareRoot = function(number) {
	return Math.sqrt(number);
}

var factorial = function(number) {
	var res = 1;
	for (i = 2; i <= number; i++) {
		res *= i;
	}
	return res;
}

var findAnagrams = function(string) {
	var listeMots = [];
	string = string.split("").sort().join("").toLowerCase();
	if (string.length < 2) {
		listeMots.push([string]);
	} else {
		for (var i = 0; i < string.length; i++) {
			var lettre = string[i];
			var mot = string.substr(0, i) + string.substr(i + 1, string.length - 1);
			var tabloMot = findAnagrams(mot);
			for (var j = 0; j < tabloMot.length; j++) {
				listeMots.push(lettre + tabloMot[j]);
			}
		}
	}
	return listeMots;
}

var convertToCelsius = function(number) {
	return Math.round((number - 32) * 5 / 9);
}

var letterPosition = function(array) {
	var tablo = [];
	var mot = array.join("").toUpperCase();
	for (i = 0; i < mot.length; i++) {
		tablo.push(mot.charCodeAt(i) - 64);
	}
	return tablo;
}
