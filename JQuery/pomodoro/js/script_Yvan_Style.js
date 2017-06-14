// *** Yvan style ***

var DURATION = 25 * 60; // 25 minutes
var TIME_LEFT = DURATION;
var STATE = "stop";
var INTERVAL;

function print(time) {
	var minutes = Math.floor(time / 60);
	var secondes = time % 60;
	if (minutes < 10) {
		minutes = "0" + minutes;
	}
	if (secondes < 10) {
		secondes = "0" + secondes;
	}
	$(".time").text(minutes + ":" + secondes);
}

function play() {
	if (STATE != "play") {
		STATE = "play";
		INTERVAL = window.setInterval(function() {
			TIME_LEFT = TIME_LEFT - 1;
			print(TIME_LEFT);
		}, 1000);
	}
}

function pause() {
	STATE = "pause";
	window.clearInterval(INTERVAL);
}

function stop() {
	STATE = "stop";
	window.clearInterval(INTERVAL);
	TIME_LEFT = DURATION;
	print(TIME_LEFT);
}

$(document).ready(function() {
	$("#play").click(play);
	$("#pause").click(pause);
	$("#stop").click(stop);
	print(TIME_LEFT);
});
