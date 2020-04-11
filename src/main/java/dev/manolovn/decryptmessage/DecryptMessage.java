package dev.manolovn.decryptmessage;

public class DecryptMessage {

    /*
      26 letters
      "dnotq"
        ^
      d -> c : d - 1
      letter -> ascii value + 1
      "crime"

      ascii(firstLetter) + 1
      int newLetter = ascii(previousLetter) + ascii(currentLetter)
      while (newLetter > 'z') newLetter -= 26;
      newLetterChar = (char) newLetter

      int newLetter = ascii(currentLetter) - ascii(previousLetter)
      while (newLetter < 'a') newLetter += 26;
      ascii(firstLetter) - 1

      subtract 1 if first letter
      else subtract the previous letter value
      while we're outside of 'a' - 'z' add 26
      store previous value
    */
    static String decrypt(String word) {
        if (word.length() <= 0) {
            return "";
        }

        char[] w = new char[word.length()];

        w[0] = (char) ((int) word.charAt(0) - 1);
        int maxValue = 'z';
        int minValue = 'a';

        for (int i = 1; i < word.length(); i++) {
            int n = (int) word.charAt(i) - (int) word.charAt(i - 1);
            while (n < minValue) {
                n += 26;
            }
            w[i] = (char) n;
        }

        return new String(w);
    }
}
