function main() {
	console.log(calculateApprMax());

	printResults();
}

function printResults() {
	var max = calculateApprMax();

	for(var i = 2; i < max; i++) {
		if(testInteger(i)) console.log(i);
	}
}

function calculateApprMax() {
	var nineToTheFifth = 59049;

	var fifthsAdded = nineToTheFifth;
	var allNines = 9;
	var i = 1;

	while(allNines < fifthsAdded) {
		i++;
		fifthsAdded = nineToTheFifth * i;
		allNines = calcAllNines(i);
	}

	return fifthsAdded;
}

function calcAllNines(i){
	return Math.pow(10,i) - 1;
}

function testInteger(i) {
	return i === calcFifthsAdded(i);
}

function calcFifthsAdded(i) {
	var s = '' + i;

	var sum = 0;

	for(var k = 0; k < s.length; k++){
		sum += Math.pow(parseInt(s[k]),5);
	}

	return sum;
}

main();
