var print = function (x) {
	process.stdout.write(x + ", ");
}

var polygonal = function (i, n) {
	return (
		(i - 2) * n * n -
		(i - 4) * n 
	) / 2;
}

var verify = function (arr, i) {
	if((i / 1000) % 10 >= 1 && i < 10000 && (i / 10) % 10 >= 1 ) {
		arr.push(i);
	}

	return i;
}

/**
 * Verify that these two numbers are part of a cycle.
 */
var vCycle = function (n, m) {

	return Math.floor(n / 100) === m % 100;
}

/**
 * For Each verify that these two numbers are part of a cycle.
 */
var fevCycle = function ( n, resArr, ignArr, gMap ) {
	return function (m) { 
		if( vCycle(n, m) ) {
			// go deeper
			console.log( n + ", " + m + ", " + resArr );

			ppvCycle( m, resArr.slice(0).push(m), ignArr, gMap );
		}
	}
}

/**
 * Per-Polygon verify cycle.
 */
var ppvCycle = function ( n, resArr, ignArr, gMap ) {
	console.log( resArr );

	if ( resArr.length === 6 ) {
		console.log( resArr );
		return;
	}

	for( var i = 0; i < 5; i++ ) {
		if(ignArr[i]) break;

		var cpIgnArr = ignArr.slice(0);
		cpIgnArr[i] = true;

		gMap[i].forEach( fevCycle( n, resArr, cpIgnArr, gMap ) );
	}
}

var globalMap = [];

for ( var i = 3; i <= 8; i++) {
	var arr = [];

	console.log(i + ":")

	for (var j = 19; j < 210; j++) {
		if (verify(arr, polygonal(i, j) ) > 9999) break;
	}

	arr.forEach(print);

	globalMap.push(arr);

	console.log("");
}

function initlzr ( ) {
	return function(n) {
		ppvCycle( n, [ n ], [ false, false, false, false, false ], globalMap );
	}
}

console.log ( "::::::::::::::::::::::::::::::::::::::::::::::::::" );

globalMap[5].forEach( initlzr() );
