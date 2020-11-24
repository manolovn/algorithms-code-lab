package dev.manolovn.awardbudgetcuts;

import java.util.Arrays;

/**
 * difficulty: HARD
 * topic: GREEDY
 */
public class AwardBudgetCuts {

    /*
      [2, 100, 50, 120, 1000], newBudget = 190

      [2, 50, 100, 120, 1000]

      1. sort reversed
      2. find the grantsArray <= newBudget --> sum() = sumGA; extract index
      3. divide newBudget (sumGA) / grantsArray.length - index
    */
    static double findGrantsCap(double[] grantsArray, double newBudget) {
        Arrays.sort(grantsArray);
        double sum = 0, cup = 0;
        for (int i = 0; i < grantsArray.length; i++) {
            sum += grantsArray[i];
            if ((newBudget - sum) / grantsArray[i] >= (grantsArray.length - i - 1)) {
                cup = (newBudget - sum) / (grantsArray.length - i - 1);
            } else {
                break;
            }
        }
        if (cup == 0.0) {
            cup = newBudget / grantsArray.length;
        }
        return cup;
    }

    static double findGrantsCap_alternative(double[] grantsArray, double newBudget) {
        Arrays.sort(grantsArray);
        double len = grantsArray.length;
        double acc = 0;
        for (int i = 0; i < grantsArray.length; i++) {
            if ((newBudget - acc) / (len - i) <= grantsArray[i])
                return (newBudget - acc) / (len - i);
            acc += grantsArray[i];
        }
        return newBudget / len;
    }
}
