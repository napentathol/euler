/**
 * Created by Alex on 4/15/2015.
 */

function calc(arr, sum) {
    if( sum < 0 ) return 0;
    if( sum === 0 ) return 1;
    if( arr.length === 1 ) return 1;

    var n = 0;

    for( var i = 0; i < arr.length; i++ ) {
        n += calc(arr.slice(i, arr.length), sum - arr[i]);
    }

    return n;
}

function main() {
    var coinTypes = [200, 100, 50, 20, 10, 5, 2, 1];

    console.log(calc(coinTypes, 1));
    console.log(calc(coinTypes, 2));
    console.log(calc(coinTypes, 5));
    console.log(calc(coinTypes, 10));
    console.log(calc(coinTypes, 20));
    console.log(calc(coinTypes, 50));
    console.log(calc(coinTypes, 100));
    console.log(calc(coinTypes, 200));
}

main();