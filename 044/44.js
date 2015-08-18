function pentagon(i) {
	return i * ( 3 * i - 1) / 2;
}

function isPentagon(i) {
	return 0 === (Math.sqrt(24 * i  + 1) + 1) % 6
}

function test(j, k) {
	var pj = pentagon(j);
	var pk = pentagon(k);

	var m = Math.abs(pj - pk);

	if(isPentagon(m)) {
		var n = pj + pk;

		if(isPentagon(n)) {
			console.log(
"both\tj: " + j +
"\tk: " + k +
"\tpj: " + pj +
"\tpk: " + pk +
"\tm: " + m +
"\tn: " + n 
			);
		} else {
                        console.log(
"one\tj: " + j +
"\tk: " + k +
"\tpj: " + pj +
"\tpk: " + pk +
"\tm: " + m +
"\tn: " + n
                        );
		}
	}
}

function main() {
	var max = 100000; //4294967296;
	
	for( var i = 1; i < max; i++ ) {
		for ( var j = i + 1; j < max; j++ ) {
			test(i, j);
		}
	}
}

main();
