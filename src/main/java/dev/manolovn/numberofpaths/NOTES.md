## Combinatorial Remark

There is a closed formula that answers this question, called the `Catalan Number Formula`. 
This formula is based on the fact that every path from `(0,0)` to `(n-1,n-1)` is parallel 
to a sequence of `n-1 pairs` of parentheses which are correctly matched: Take a path 
sequence of N’s and E’s. since the car begins at `(0,0)` and ends at `(n-1,n-1)`, it needs to 
go exactly `n-1` times East, and `n-1` times North. Put differently, all sequences consist 
of `n-1` E’s and `n-1` N’s. Just like every balanced parenthesis string has the same number 
of “(“ and “)” signs. Furthermore, in every pair `(i,j)`, the first coordinate is the number 
of times the car went east so far, and the second coordinate is the number of times the car 
went north. This indicates that the diagonal restriction means the number of E’s, in every 
prefix of the string is equal or greater than the number of N’s. Just as in every balanced 
parenthesis string, the number of “(“ is is equal or greater than the number of “)”. The number 
of the balanced parenthesis strings of n-1 pairs, is given by the Catalan Number Formula: . 
The proof for its correctness is beyond our scope, but is located in the Catalan Number Wikipedia page.

Note that although this formula is mathematically closed, calculating the Binomial Coefficient , 
is done in O(n) runtime complexity, so calculating the number directly doesn’t improve the asymptotic 
runtime complexity. But direct calculation spares the need for saving previous values, so the space 
complexity may be reduced to O(1) this way.

### References

- Catalan Number: https://en.wikipedia.org/wiki/Catalan_number
- Binomial coefficient: https://en.wikipedia.org/wiki/Binomial_coefficient