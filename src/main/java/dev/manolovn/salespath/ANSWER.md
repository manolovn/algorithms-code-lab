# Sales Path

Obviously iterating through all paths again and again is not a good solution, since its wasteful 
in terms of time and memory. But intuitively if we find a solution that uses previous calculations somehow. 
This hints that the solution should involve recursion in some manner.

First we notice that if the root is also a leaf, the best Sales Path, is simply the value in the node itself. 
This is the base case for the solution. If the root has children, then the minimal Sales Path is also 
a minimal path from the root’s child. Thus, if we already know the minimal cost for the root’s children, 
then the minimal cost for the root is simply the minimum of the values for its children plus the value stored 
in the root itself. A solution to this question, using these facts is given below:

## Time Complexity: 
let N be the number of nodes in the tree. Notice that getCheapestCost is applied to every node exactly once. 
Therefore, there are overall `O(N)` calls to getCheapestCost.

## Space Complexity: 
Every time the function recurses, it consumes only a constant amount of space. However, due to the nature 
of the recursion we used, the stack call holds N instances of getCheapestCost which makes the total space complexity 
to be `O(N)`.