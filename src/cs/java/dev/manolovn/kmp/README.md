# KMP (Knuth Morris Pratt) algorithm

The KMP is a pattern matching algorithm which searches for occurrences of a "word" W within 
a main "text string" S by employing the observation that when a mismatch occurs, we have the 
sufficient information to determine where the next match could begin.We take advantage of 
this information to avoid matching the characters that we know will anyway match.
The worst case complexity for searching a pattern reduces to O(n).

### Complexity
O(n)

### Solves
- Pattern matching

### Scenario
- Search a word W in a string S

### Tags
pattern matching - strings
