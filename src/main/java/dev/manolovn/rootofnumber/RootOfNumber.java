package dev.manolovn.rootofnumber;

import static java.lang.Math.abs;
import static java.lang.Math.pow;

public class RootOfNumber {

    static double root(double x, int n) {
        double min = 0.0;
        double max = x;

        double mid = x / 2;
        double y = 0.0;

        while (min <= max) {
            double diff = abs(x - (pow(mid, n)));
            if (diff < 0.001) {
                return mid;
            } else if (x < (pow(mid, n))) {
                max = mid;
            } else if (x > (pow(mid, n))) {
                min = mid;
            }
            mid = (max + min) / 2;
        }

        return y;
    }
}
