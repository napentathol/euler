Some Interesting thoughts on the Fibonacci Sequence
---

The standard formulation of the fibonacci sequence is  
`F(n) = F(n-1) + F(n-2)`

Where  
`F(0) = 0,  
F(1) = 1`

However, there is a more advanced formulation where:  
`F(n) = F(n-c) * F(c+1) + F(n-c-1) * F(c)`

where  
c is any constant, positive integer,  
`F(0) = 0,  
F(1) = 1`

An example of this is n=5, c=2  
`F(5) = F(3)*F(3) + F(2)*F(2) = 2*2 + 1*1 = 5`

Or n=7, c=3  
`F(7) = F(4)*F(4) + F(3)*F(3) = 3*3 + 2*2 = 13`

Or n=12, c=4  
`F(12) = F(8)*F(5) + F(7)*F(4) = 21*5 + 13*3 = 105 + 39 = 144`

Clearly the optimal way to solve F(n) is  
`F(n) = F(a) * F(a) + F(b) * F(b)` where n is odd  
      `= F(a) * (F(a) + F(b)) + F(a)*F(b)` where n is even  
    `a = ceil(n/2)  
    b = a - 1`
