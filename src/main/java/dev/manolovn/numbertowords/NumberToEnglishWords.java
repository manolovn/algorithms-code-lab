package dev.manolovn.numbertowords;

/**
 * source: https://leetcode.com/problems/integer-to-english-words/
 * difficulty: HARD
 * topic: MATH + STRINGS
 */
public class NumberToEnglishWords {

    private static final int BILLION = 1000000000;
    private static final int MILLION = 1000000;
    private static final int THOUSAN = 1000;

    /**
     * Time:  O(n)
     * Space: O(1)
     */
    public String numberToWords(int num) {
        if (num == 0) return "Zero";

        int billion = num / BILLION;
        int million = (num - billion * BILLION) / MILLION;
        int thousand = (num - billion * BILLION - million * MILLION) / THOUSAN;
        int hundred = num - billion * BILLION - million * MILLION - thousand * THOUSAN;

        String words = "";
        if (billion != 0) {
            words = three(billion) + " Billion";
        }
        if (million != 0) {
            if (!words.isEmpty()) words += " ";
            words += three(million) + " Million";
        }
        if (thousand != 0) {
            if (!words.isEmpty()) words += " ";
            words += three(thousand) + " Thousand";
        }
        if (hundred != 0) {
            if (!words.isEmpty()) words += " ";
            words += three(hundred);
        }
        return words;
    }

    private String three(int num) {
        int hundred = num / 100;
        int rest = num - hundred * 100;
        String words = "";
        if (hundred * rest != 0) {
            words = one(hundred) + " Hundred " + two(rest);
        } else if (hundred == 0 && rest != 0) {
            words = two(rest);
        } else if (hundred != 0 && rest == 0) {
            words = one(hundred) + " Hundred";
        }
        return words;
    }

    private String two(int num) {
        if (num == 0) return "";
        if (num < 10) return one(num);
        if (num < 20) return ten(num);
        int tens = num / 10;
        int rest = num - tens * 10;
        if (rest != 0) return ten(tens) + " " + one(rest);
        return ten(tens);
    }

    private String ten(int num) {
        switch (num) {
            case 2:
                return "Twenty";
            case 3:
                return "Thirty";
            case 4:
                return "Forty";
            case 5:
                return "Fifty";
            case 6:
                return "Sixty";
            case 7:
                return "Seventy";
            case 8:
                return "Eighty";
            case 9:
                return "Ninety";
            case 10:
                return "Ten";
            case 11:
                return "Eleven";
            case 12:
                return "Twelve";
            case 13:
                return "Thirteen";
            case 14:
                return "Fourteen";
            case 15:
                return "Fifteen";
            case 16:
                return "Sixteen";
            case 17:
                return "Seventeen";
            case 18:
                return "Eighteen";
            case 19:
                return "Nineteen";
        }
        return "";
    }

    private String one(int num) {
        switch (num) {
            case 1:
                return "One";
            case 2:
                return "Two";
            case 3:
                return "Three";
            case 4:
                return "Four";
            case 5:
                return "Five";
            case 6:
                return "Six";
            case 7:
                return "Seven";
            case 8:
                return "Eight";
            case 9:
                return "Nine";
        }
        return "";
    }
}
