## Time Complexity

let `N` be the length of the input array. There are `N-1` iterations, in each we place one element in its place. 
Every iteration takes 2 flips to move every member in the array to its place, and each takes `O(N)` at most. In 
addition, every iteration we find the maximal element, which is also done in `O(N)`. There are `N-1` iterations 
that take `O(N)` time thus in total the algorithm takes `O(N^2)` time.

## Space Complexity

the algorithm doesn’t initiate more than a few auxiliary variables, thus it is entirely in place 
and uses only `O(1)` space.