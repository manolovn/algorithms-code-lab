package dev.manolovn.s2020.d02;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * --- Day 2: Password Philosophy ---
 *
 * Their password database seems to be a little corrupted: some of the passwords wouldn't have been allowed by the
 * Official Toboggan Corporate Policy that was in effect when they were chosen.
 */
public class PasswordPhilosophy {

    /**
     * To try to debug the problem, they have created a list (your puzzle input) of passwords (according to the
     * corrupted database) and the corporate policy when that password was set.
     *
     * For example, suppose you have the following list:
     * 1-3 a: abcde
     * 1-3 b: cdefg
     * 2-9 c: ccccccccc
     *
     * Each line gives the password policy and then the password. The password policy indicates the lowest and highest
     * number of times a given letter must appear for the password to be valid. For example, 1-3 a means that the
     * password must contain a at least 1 time and at most 3 times.
     *
     * In the above example, 2 passwords are valid. The middle password, cdefg, is not; it contains no instances of b,
     * but needs at least 1. The first and third passwords are valid: they contain one a or nine c, both within the
     * limits of their respective policies.
     *
     * How many passwords are valid according to their policies?
     */
    public static int part1(List<String> lines) {

    }

    static class Record {
        int min;
        int max;
        char c;
        String pass;

        public Record(int min, int max, char c, String pass) {
            this.min = min;
            this.max = max;
            this.c = c;
            this.pass = pass;
        }

        public static Record fromRaw(String line) {

        }
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File("input.txt"));
        List<String> input = new ArrayList<>();
        while (scanner.hasNextLine()) {
            input.add(scanner.nextLine());
        }
        System.out.println(part1(input));
        scanner.close();
    }
}
