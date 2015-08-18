/**
 * Created by Alex on 4/15/2015.
 */

function cyclic (p) {
    return (Math.pow(10, p - 1) - 1) / p;
}

function main() {
    console.log(cyclic(7));
    console.log(cyclic(17));
    console.log(cyclic(119));
    console.log(cyclic(19));
    console.log(cyclic(61));
}

main();