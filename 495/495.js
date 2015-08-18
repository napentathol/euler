function factorial( n ) {
	if(n < 2)  return 1;
	if(n == 2) return 2;

	return n * factorial(n - 1);
}

function getFactorialFactors( n ) {
	var fac = factorial(n);
	
	var retArr = [];
	var backArr = [];

	for(var i = 1; i < Math.sqrt(fac); i++ ) {
		if( fac % i == 0 ) {
			retArr.push(i);
			backArr.push( fac / i );
		}
	}

	return retArr.concat(backArr.reverse());
}

function solver(k, s, arr, min, max) {
	var sum = 0;

	if(1 >= k) return min < max ? 1 : 0;

	for(var i = min; i < max; i++) {
		var newS;
		var sPos = max - 1;

		if(s % arr[i] != 0) continue;
			
		newS = s / arr[i];

		for( ; arr[sPos] > newS; sPos--);

		res = solver(k - 1, newS, arr, i + 1, sPos + 1);

		if( res == 0 ) break;

		sum += res;
	}

	return sum;
}

function w(n, k) {
	var factors = getFactorialFactors( n );
	var fac = factors[factors.length - 1];

	return solver(k, fac, factors, 0, factors.length );
}


function main() {
	for(var i = 2; i < 12; i++ ) {

	var res = [];

	for(var j = 2; j < 12; j++ ) {
		res.push( w(i, j) );
	}

	console.log(i + " :\t " + getFactorialFactors(i).length);
	console.log(res);

	}
}

main();
