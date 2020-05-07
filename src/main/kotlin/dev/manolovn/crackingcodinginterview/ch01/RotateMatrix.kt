package dev.manolovn.crackingcodinginterview.ch01

import dev.manolovn.crackingcodinginterview.ch01.RotateMatrix.rotate90deg

/**
 * Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes,
 * write a method to rotate the image by 90 degrees. Can you do this in place?
 */
object RotateMatrix {

    /**
     * Very simple problem, we just need to take care of indexes while traversing the matrix
     *
     *   1 2 3 4         d 9 5 1
     *   5 6 7 8   >>>   e a 6 2
     *   9 a b c   >>>   f b 7 3
     *   d e f g         g c 8 4
     *
     * We can do the rotation in place, to do that we just need an extra variable to store the cell value
     * while swapping cells
     *
     * Time : O(n^2) due to all the elements in the matrix
     * Space: O(1) due to the swap is done "in place" using a temp variable
     */
    fun rotate90deg(matrix: Array<Array<Any>>): Array<Array<Any>> {
        val n = matrix.size
        for (layer in 0 until (n / 2)) {
            val last = n - layer - 1
            for (i in layer until last) {
                val offset = i - layer
                val top = matrix[layer][i]
                // left to top
                matrix[layer][i] = matrix[last - offset][layer]
                // bottom to left
                matrix[last - offset][layer] = matrix[last][last - offset]
                // rigth to bottom
                matrix[last][last - offset] = matrix[i][last]
                // top to right
                matrix[i][last] = top
            }
        }
        return matrix
    }
}

fun main() {
    val result = rotate90deg(
        arrayOf(
            arrayOf<Any>(1, 2, 3, 4),
            arrayOf<Any>(5, 6, 7, 8),
            arrayOf<Any>(9, 'a', 'b', 'c'),
            arrayOf<Any>('d', 'e', 'f', 'g')
        )
    )
    result.forEach { println(it.contentToString()) }
}