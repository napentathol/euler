var maxMem = 1000000;

function collatzLength(n) {
    if(n == 1) return 1;

    if(n % 2 == 0) {
        return collatzLength(n / 2) + 1;
    } else {
        return collatzLength(3 * n + 1) + 1;
    }

    return memory[n-1];
}

function greatestCollatzLength() {
    var out = 1;
    var max = 1;

    for(var i=1; i < 1000000; i++){
        var tmp = collatzLength(i);

        if(tmp > max) {
            max = tmp;
            out = i;
        }
    }

    return out;
}

console.log(collatzLength(13));

console.log(collatzLength(40));

console.log(greatestCollatzLength());
