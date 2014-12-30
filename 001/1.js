function sum(n) {
    return (n * (n+1)) / 2;
}

function f(n,m){
    return Math.ceil(m/n) - 1;
}

function g(n) {
    return 5 * sum(f(5,n)) + 3*sum(f(3,n)) - 15 * sum(f(15,n));
}

console.log(g(10));
console.log(g(1000));
