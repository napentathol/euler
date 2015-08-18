function calcOuterSpiral(n){
	if(n === 1) return 1;

	var m = n-1;
	var sqr = n * n;

	return sqr*4 - m * 6;
}

function calcTotalSpirals(n){
	if(n===1) return 1;
	if(n%2!==1) return -1;

	return calcTotalSpirals(n-2) + calcOuterSpiral(n);
}

function print(n){
	console.log(calcTotalSpirals(n));
}

print(1);
print(2);
print(3);
print(5);
print(1001);
