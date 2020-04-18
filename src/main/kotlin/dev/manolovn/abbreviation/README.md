# Abbreviation

You can perform the following operations on the string `a`:

1. Capitalize zero or more of 's lowercase letters.
2. Delete all of the remaining lowercase letters in .

Given two strings `a` and `b` determine if it's possible to make `a` equal to `b` as described. 
If so, print `YES` on a new line. Otherwise, print `NO`.

For example, given `a = AbcDE` and `b=ABDE`, in `a` we can convert `b` and delete `c` to match `b` .
If `a = AbcDE` and `b=AFDE`, matching is not possible because letters may only be capitalized or discarded, 
not changed.

## Function Description

Complete the function `abbreviation` in the editor below. It must return either `YES` or `NO`.

abbreviation has the following parameter(s):
- a: the string to modify
- b: the string to match

## Input Format

The first line contains a single integer , the number of queries.

Each of the next  pairs of lines is as follows:
- The first line of each query contains a single string, .
- The second line of each query contains a single string, .

## Constraints
```
String  consists only of uppercase and lowercase English letters, ascii[A-Za-z].
String  consists only of uppercase English letters, ascii[A-Z].
```

## Output Format

For each query, print YES on a new line if it's possible to make string  equal to string . Otherwise, print NO.

## Sample Input
```
1
daBcd
ABC
Sample Output
YES
```

### Explanation

We have `a=daBcd` and `b=ABC`. We perform the following operation:

1. Capitalize the letters a and c in  so that  dABCd.
2. Delete all the remaining lowercase letters in  so that  ABC.
3. Because we were able to successfully convert  to , we print YES on a new line.

__Source: https://www.hackerrank.com/challenges/abbr/problem__