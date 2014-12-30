function fib(arr) {
    arr.push(arr[0] + arr[1]);

    return arr.slice(1,3);
}

function sumEvenFibs(n) {
    var sum = 0;
    var fibs = [1, 2];

    while(fibs[1] < n) {
        if(fibs[1] % 2 == 0) sum += fibs[1];

        fibs = fib(fibs);
    }

    return sum;
}

console.log("result: " + sumEvenFibs(10));
console.log("result: " + sumEvenFibs(50));
console.log("result: " + sumEvenFibs(4000));
console.log("result: " + sumEvenFibs(4000000));
