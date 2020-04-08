package dev.manolovn.busiestmall;

public class BusiestTimeInTheMall {

    static int findBusiestPeriod(int[][] data) {
        int solutionTs = 0; // store the best time stamp
        int maxVisitors = 0;
        int candidateTs = 0; //store the current time stamp
        int currentVisitors = 0; //current visitors till current data point

        for (int[] datum : data) {
            if (datum[0] != candidateTs) {
                if (currentVisitors > maxVisitors) {
                    maxVisitors = currentVisitors;
                    solutionTs = candidateTs;
                }
                candidateTs = datum[0];
            }
            currentVisitors += datum[2] == 1 ? datum[1] : -datum[1];
        }

        return solutionTs;
    }
}