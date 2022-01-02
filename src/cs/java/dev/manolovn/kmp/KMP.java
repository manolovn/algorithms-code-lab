package dev.manolovn.kmp;

public class KMP {

    public boolean patternExists(char[] text, char[] pat) {
        int[] lps = computeLPS(pat);
        int i = 0, j = 0;
        while (i < text.length && j < pat.length) {
            if (text[i] == pat[j]) {
                i++;
                j++;
            } else {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        return j == pat.length;
    }

    private int[] computeLPS(char[] str) {
        int[] lps = new int[str.length];
        lps[0] = 0;
        int j = 0;
        for (int i = 1; i < str.length; i++) {
            if (str[j] == str[i]) {
                lps[i] = j + 1;
                j++;
                i++;
            } else {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    lps[i] = j + 1;
                    i++;
                }
            }
        }
        return lps;
    }

    public static void main(String[] args) {
        String str = "abcabdabc";
        String pattern = "abc";
        KMP kmp = new KMP();
        System.out.println(kmp.patternExists(str.toCharArray(), pattern.toCharArray()));
    }
}
