package com.lusr.forwin.newCoder.basic;

import java.util.Scanner;

public class Digui {
    //abdsdaabd
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            hanour(n, 'a', 'b', 'c');
            System.out.println(count);
        }
    }

    static int count = 0;

    private static void hanour(int n, char a, char b, char c) {
        count++;
        if (n == 1) {
            System.out.println(a + " - > " + c);
            return;
        }
        hanour(n - 1, a, c, b);
        System.out.println(a + " - > " + c);
        hanour(n - 1, b, a, c);
    }
}
