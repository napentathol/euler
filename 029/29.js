/*
Javascript number resolution not great enough.
*/

function pushPow(a,b) {
	var num = Math.pow(a,b);

	if(arr.indexOf(num) === -1) {
		arr.push(num);
	}
}

function bTerate(a,k) {
	for(var i = 2; i <= k; i++) {
		pushPow(a,i);
	}
}

function aTerate(k) {
	for(var i = 2; i <= k; i++) {
		bTerate(i,k);
	}
}

function main() {
	arr=[];

	aTerate(5);
	console.log(arr.length);
	console.log(arr);

	arr=[];

	aTerate(100);
        console.log(arr.length);
	console.log(arr);
}

main();
