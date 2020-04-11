# Decrypt Message

First of all, notice that the first letter is very easy to decrypt:

1. Convert the first letter back to its ASCII value.
2. Subtract 1 from it.
3. Move the value to be in the range of a-z ASCII values (97-122), by adding 26.
4. Convert the result back to a character.

The decryption of the rest of the letters is done by almost the same algorithm - given the decrypted 
previous letter prev, and its value after the second step of encryption - denoted secondStepPrev:

1. Convert the current letter back to its ASCII value.
2. Subtract secondStepPrev from it.
3. Move the value to be in the range of a-z ASCII value (97-122), by adding multiples of 26.
4. Convert the result back to a character. Store its ASCII value in prev, and add its value 
to secondStepPrev (for the decryption of the next letter).

Let’s examine the algorithm using the following notation:

- dec[n] - the n’th letter before encryption.
- enc[n] - the n’th letter after encryption.
- secondStep[n] - the n’th letter immediately after step 2 in the encryption.

The encryption algorithm gives the following relation for some integer m (which represents the number of times we need to add 26 to get to an ascii value):

`enc[n] = dec[n] + secondStep[n-1] + 26m`

By isolating dec[n], we get:

`dec[n] = enc[n] - secondStep[n-1] - 26m`

Though the value of m isn’t initially known, since the value of the decrypted letter must be in the ASCII range of a-z, the decrypted letter is easily found adding 26’s to enc[n] - secondStep[n] until it is in the right range.

## Time Complexity
The function’s asymptotic time complexity is `O(N)`, where `N` is the length of the input string. 
the loop that iterates through the letters in the input is performed `N` times. In the loop, 
almost every step is done in `O(1)`, except for the loop that is supposed to move the decrypted letter 
back to the range of `a-z`. Theoretically, the secondStep may grow linearly with the size of the input. 
There are two ways to deal with this:

1. Instead of secondStep itself, we may only keep its remainder after being divided by 26 
(since we add/subtract multiples of `26` anyway, the equation `dec[N] = enc[N] - (secondStep[N-1] % 26)- 26M` 
still holds, only for a different `M`). This way all values in every iteration are kept in a constant range. 
2. Note that since in practice this function is used only for words in the English language, the input 
is bounded and we therefore may ignore the growth of the secondStep anyway.

## Space Complexity
The space usage is also `O(N)` since the output is the same size of the input, and we only keep the output 
and the second step in storage.