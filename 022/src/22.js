/**
 * Created by Alex on 4/22/2015.
 */

fs = require('fs');

function parse(data) {
    return data.split('"').join('').split(',');
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

    fs.readFile('p022_names.txt', 'utf8', function (err, data) {
        if (err) {
            return console.log(err);
        }
        var strings = parse(data).sort();

        for(var i = 0; i < strings.length; i++) {
            count += getStringCode(strings[i]) * (i + 1);
        }

        console.log("" + count);
    });
}

main();
