var firstFew = [220, 284, 1184, 1210, 2620, 2924, 5020, 5564, 6232, 6368];

var sum = firstFew.reduce(function(p, n) {
  return p + n;
});

console.log( sum );
