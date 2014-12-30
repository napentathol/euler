function sum(n) {
    return (n * (n + 1)) / 2
}

function squareSum(n) {
    return (n * (n + 1) * (2 * n + 1)) / 6;
}

function f(n) {
    return sum(n) * sum(n) - squareSum(n);
}

console.log('result: ' + f(10));
console.log('result: ' + f(100));
