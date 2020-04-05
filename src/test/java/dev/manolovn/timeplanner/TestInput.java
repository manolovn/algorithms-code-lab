package dev.manolovn.timeplanner;

class TestInput {

    static Object[] input0() {
        int[][] slotsA = new int[][]{new int[]{10, 50}, new int[]{60, 120}, new int[]{140, 210}};
        int[][] slotsB = new int[][]{new int[]{0, 15}, new int[]{60, 70}};
        int duration = 8;
        int[] expected = new int[]{60, 68};

        return new Object[]{slotsA, slotsB, duration, expected};
    }

    static Object[] input1() {
        int[][] slotsA = new int[][]{new int[]{7, 12}};
        int[][] slotsB = new int[][]{new int[]{2, 11}};
        int duration = 5;
        int[] expected = new int[]{};

        return new Object[]{slotsA, slotsB, duration, expected};
    }

    static Object[] input2() {
        int[][] slotsA = new int[][]{new int[]{6, 12}};
        int[][] slotsB = new int[][]{new int[]{2, 11}};
        int duration = 5;
        int[] expected = new int[]{6, 11};

        return new Object[]{slotsA, slotsB, duration, expected};
    }

    static Object[] input3() {
        int[][] slotsA = new int[][]{new int[]{1, 10}};
        int[][] slotsB = new int[][]{new int[]{2, 3}, new int[]{5, 7}};
        int duration = 2;
        int[] expected = new int[]{5, 7};

        return new Object[]{slotsA, slotsB, duration, expected};
    }

    static Object[] input4() {
        int[][] slotsA = new int[][]{new int[]{0, 5}, new int[]{50, 70}, new int[]{120, 125}};
        int[][] slotsB = new int[][]{new int[]{0, 50}};
        int duration = 8;
        int[] expected = new int[]{};

        return new Object[]{slotsA, slotsB, duration, expected};
    }

    static Object[] input5() {
        int[][] slotsA = new int[][]{new int[]{10, 50}, new int[]{60, 120}, new int[]{140, 210}};
        int[][] slotsB = new int[][]{new int[]{0, 15}, new int[]{60, 70}};
        int duration = 8;
        int[] expected = new int[]{60, 68};

        return new Object[]{slotsA, slotsB, duration, expected};
    }

    static Object[] input6() {
        int[][] slotsA = new int[][]{new int[]{10, 50}, new int[]{60, 120}, new int[]{140, 210}};
        int[][] slotsB = new int[][]{new int[]{0, 15}, new int[]{60, 72}};
        int duration = 12;
        int[] expected = new int[]{60, 72};

        return new Object[]{slotsA, slotsB, duration, expected};
    }
}
