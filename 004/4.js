function checkPalindrome(n) {
    var str = "" + n;

    return str == str.split('').reverse().join('');
}

top : for(var i = 999; i > 100; i--) {
    for(var j = 999; j >= i; j--) {
        if(checkPalindrome(i * j) && i * j > 900000) {
            console.log('' + i * j + ', ' + i + ', ' + j);
//            break top;
        }
    } 
}
