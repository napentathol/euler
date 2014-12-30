/**
 * Created by napentathol on 12/16/14.
 */

var main = function main() {
    for(var n=1; n <= 18; n++) {
        tripleCount(n);
    }

    var count = 0;

    for(var n=1; n <= 19; n++){
        count += factorial(n);
    }

    console.log(count);
};

var factorial = function factorial(n) {
    var out = 1;

    for(var m = 1; m <= n; m++) {
	out *= m;
    }

    return out;
};

var gcd = function gcd(i, j) {
    if(j > i) return gcd(j, i);

    if(i == 0 && j == 0) {
        return 0;
    } else if(!j) {
        return i;
    } else {
        return gcd(j, i%j);
    }
};

var time = new Date().getTime();

var tripleCount = function tripleCount(n) {
    var count = 0;

    //process.stdout.write('Triples: ');

    for(var i = 0; i <= n; i++){
        for(var j = 0; j <= i; j++) {
            if(gcd(n, gcd(i,j)) === 1){
    //            process.stdout.write('( '+n+', '+i+', '+j+'); ');

                if(i === j && i === n){
                    count += 1;
                } else if(i === j || i === n){
                    count += 3;
                } else {
                    count += 6;
                }
            }
        }
    }
    //process.stdout.write('\n');

    var estimate = estFunc(n);

    console.log('N:\t'+n+'\tCount:\t'+count+'\tEstimate:\t'+estimate+'\tDifference:\t' + (count - estimate));
    return count;
};

var estFunc = function estFunc(n) {
    return (3 * n * (n + 1) - 6);
};

main();

function powerset(ary) {
    var ps = [[]];
    for (var i=0; i < ary.length; i++) {
        for (var j = 0, len = ps.length; j < len; j++) {
            ps.push(ps[j].concat(ary[i]));
        }
    }
    return ps;
}

function createNSizedArray(n) {
    var outArray = [];

    for(var i = 0; i < n; i++) {
        outArray.push(i);
    }

    return outArray;
}
 
var res = powerset(createNSizedArray(49));

console.log(JSON.stringify(res.length));
