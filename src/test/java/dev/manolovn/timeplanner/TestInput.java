package dev.manolovn.timeplanner;

class TestInput {

    static Object[] input0() {
        int[][] slotsA = new int[][]{new int[]{10, 50}, new int[]{60, 120}, new int[]{140, 210}};
        int[][] slotsB = new int[][]{new int[]{0, 15}, new int[]{60, 70}};
        int duration = 8;
        int[] expected = new int[]{60, 68};

        return new Object[]{ slotsA, slotsB, duration, expected};
    }
}
