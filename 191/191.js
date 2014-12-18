var nDays = process.argv[2];

var countStore = [];

function getCount(countId) {
	var retval = 0;

	var retrieved = "";
	
	var matchCount = function matchCount(value, index, array){
		var id = value.substring(0, value.indexOf(":"));
		
		if(id === countId) {
			retval = parseInt(value.substring(value.indexOf(":")+1, value.length), 10);
			retrieved = value;
		}
	}
	
	countStore.forEach(matchCount);

	//console.log("For countid: "+ countId +", retrieved: " + retrieved + ", returning: "+retval)
	return retval;
}

function storeCount(count, countString) {
	countStore.push(countString + ":" +count);
}

function countA(hasl, depth, preva) {
	var countString = "A" + (preva ? "A" : "N") + (hasl ? "L" : "N") + depth;
	var count = getCount(countString);

	if(depth === 0) {
		count = 1;
	} else {
		count = getCount(countString);

		if(count === 0) {

			count = countO(hasl, depth - 1);

			if(!hasl) {
				count += countL(depth -1);
			}

			if(!preva) {
				count += countA(hasl, depth -1, true);
			}

			storeCount(count, countString);
		}
	}

	return count;
}

function countL(depth) {
	return depth == 0 ? 1 : countO(true, depth-1) + countA(true, depth-1, false);
}

function countO(hasl, depth) {
	var count = 0;
	var countString = "O" + (hasl ? "L" : "N") + depth;

	if(depth === 0) {
		count = 1;
	} else {
		count = getCount(countString);
		
		if(count === 0){
			count = countO(hasl, depth - 1) + countA(hasl, depth -1, false);

			if(!hasl) {
				count += countL(depth -1);
			}
			storeCount(count, countString);
		}
	}

	return count;
}

function count(depth) {
	if(depth <= 0) return 1;
	
	return countL(depth - 1) + countO(false, depth -1) + countA(false, depth -1, false);
}

console.log("input: " + nDays);

console.log("output: " + count(nDays));
