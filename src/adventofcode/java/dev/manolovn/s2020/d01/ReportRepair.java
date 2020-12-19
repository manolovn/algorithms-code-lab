package dev.manolovn.s2020.d01;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * --- Day 1: Report Repair ---
 * Collect stars by solving puzzles. Two puzzles will be made available on each day in the Advent calendar;
 * the second puzzle is unlocked when you complete the first. Each puzzle grants one star. Good luck!
 * Before you leave, the Elves in accounting just need you to fix your expense report (your puzzle input);
 * apparently, something isn't quite adding up.
 */
public class ReportRepair {

    /**
     * Specifically, they need you to find the two entries that sum to 2020 and then multiply those two numbers together.
     * <p>
     * For example, suppose your expense report contained the following:
     * 1721
     * 979
     * 366
     * 299
     * 675
     * 1456
     * <p>
     * In this list, the two entries that sum to 2020 are 1721 and 299.
     * Multiplying them together produces 1721 * 299 = 514579, so the correct answer is 514579.
     * Of course, your expense report is much larger. Find the two entries that sum to 2020;
     * what do you get if you multiply them together?
     */
    public static int reportRepair(List<Integer> input) {
        Map<Integer, Integer> m = new HashMap<>();
        for (Integer i : input) {
            if (m.containsKey(i))
                return i * m.get(i);
            m.put(2020 - i, i);
        }
        return -1;
    }

    /**
     * The Elves in accounting are thankful for your help; one of them even offers you a starfish coin they had left
     * over from a past vacation. They offer you a second one if you can find three numbers in your expense report
     * that meet the same criteria.
     * Using the above example again, the three entries that sum to 2020 are 979, 366, and 675.
     * Multiplying them together produces the answer, 241861950.
     * <p>
     * In your expense report, what is the product of the three entries that sum to 2020?
     */
    public static int threeNumbers(List<Integer> input) {
        Collections.sort(input);
        for (int i = 0; i < input.size(); i++) {
            List<Integer> pair = searchPair(input, i, 2020 - input.get(i));
            if (!pair.isEmpty()) {
                return pair.get(0) * pair.get(1) * input.get(i);
            }
        }
        return -1;
    }

    private static List<Integer> searchPair(List<Integer> input, int start, int target) {
        int l = start + 1;
        int r = input.size() - 1;
        while (l < r) {
            int sum = input.get(l) + input.get(r);
            if (sum == target) {
                return Arrays.asList(input.get(l), input.get(r));
            }
            if (sum < target) {
                l++;
            } else {
                r--;
            }
        }
        return Collections.emptyList();
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File("input.txt"));
        List<Integer> input = new ArrayList<>();
        while (scanner.hasNextLine()) {
            input.add(Integer.valueOf(scanner.nextLine()));
        }
        System.out.println(reportRepair(input));
        System.out.println(threeNumbers(input));
        scanner.close();
    }
}
