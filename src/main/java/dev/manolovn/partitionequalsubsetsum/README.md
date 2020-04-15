# Partition equal subset sum
(https://leetcode.com/problems/partition-equal-subset-sum/)

Given a non-empty array containing only positive numbers, find if the array can be partitioned 
into two subsets such that the sum of elements in both subsets is equal.

sorted? nope

## Examples
```
[1,5,5,11] : true because: sum[1,5,5] = sum[11]
[1,11,5,5] : true because: sum[1,5,5] = sum[11]
[11,5,5]   : false because: sum[5,5] != sum[11]
[1]        : false
```