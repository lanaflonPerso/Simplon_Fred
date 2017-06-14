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

main();

function main() {
  console.log(findAnagrams("abcde"));
}
