package com.lusr.forwin.tencent;

import java.util.Scanner;

public class Seonde {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] r = new int[n];
            int[] g = new int[n];
            int[] b = new int[n];

            for (int i = 0; i < n; i++) {
                r[i] = scanner.nextInt();
            }

            for (int i = 0; i < n; i++) {
                g[i] = scanner.nextInt();
            }

            for (int i = 0; i < n; i++) {
                b[i] = scanner.nextInt();
            }
            solve(n, r, g, b);
        }
    }

    private static void solve(int n, int[] r, int[] g, int[] b) {

    }

}
