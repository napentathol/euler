function isPentagon(i) {
	return 0 === (Math.sqrt(24 * i  + 1) + 1) % 6;
}

function isTriangle(i) {
	return 1 === (Math.sqrt(8 * i + 1)) % 2;
}

function hexagonal(i) {
	return i * (2 * i - 1);
}

function isTPH(i) {
	var h = hexagonal(i);
	
	if( isTriangle(h) ) {
		return isPentagon(h);
	}

	return false;
}

function main() {
	var max = 100000;

	for(var i = 0; i < max; i++) {
		if(isTPH(i)) {
			console.log("\ti: " + i + "\th" + hexagonal(i));
		}
	}
}

main();
