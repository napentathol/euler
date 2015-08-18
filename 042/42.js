fs = require('fs');

function parse(data) {
	return data.split('"').join('').split(',');
}

function isTriangle(i) {
	return 1 === (Math.sqrt(8 * i + 1)) % 2;
}

function getStringCode(word) {
	console.log(word);

	var sum = 0;
		
	word.toUpperCase().split('').forEach(function(alphabet) {
		sum += alphabet.charCodeAt(0) - 64;
	});

	return sum;
}

function main() {
	var count = 0;

	fs.readFile('p042_words.txt', 'utf8', function (err, data) {
  		if (err) {
    			return console.log(err);
  		}
		var strings = parse(data);

		for(var i = 0; i < strings.length; i++) {
			if(isTriangle(getStringCode(strings[i]))) {
				count++;
			}
		}

		console.log("" + count);
	});
}

main();
