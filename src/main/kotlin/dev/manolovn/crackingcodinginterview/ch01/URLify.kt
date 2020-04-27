package dev.manolovn.crackingcodinginterview.ch01

/**
 * Write a method to replace all spaces in a string with '%20'. You may assume that the string
 * has sufficient space at the end to hold the additional characters, and that you are given the "true"
 * length of the string
 *
 * Example:
 * input : "Mr John Smith    "
 * output: "Mr%20John%20Smith"
 */
object URLify {

    /**
     * The first idea is to create another CharArray with the same lenght that input
     * and use two pointers to transfer characters from input to output. One pointer to read that starts
     * from the truelength and another one that starts from the end of the input
     *
     * Time:  O(n) ; because we only need one pass over the input char array
     * Space: O(1) ; we modify the input so no more data structures are needed
     */
    internal fun urlify(input: CharArray, truelen: Int): String {
        val len = input.size
        var j = len - 1
        for (i in truelen - 1 downTo 0) {
            if (input[i] == ' ') {
                input[j] = '0'
                input[j - 1] = '2'
                input[j - 2] = '%'
                j -= 3
            } else {
                input[j] = input[i]
                j--
            }
        }
        return String(input)
    }
}