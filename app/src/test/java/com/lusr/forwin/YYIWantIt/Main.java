package com.lusr.forwin.YYIWantIt;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[][] arr = new int[n + 3][n + 3];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = scanner.nextInt();
                }
            }
            int derection = 1;
            int row = 0, col = 0;
            while (col < n && row < n) {
                System.out.print(arr[row][col]);
                if (col == n - 1 && row == n - 1) {
                    break;
                }
                if (derection == 1) {
                    row = row - 1;
                    col = col + 1;

                    if (col >= n) {
                        col = col - 1;
                        row = row + 2;
                        derection = -1;
                    } else if (row < 0) {
                        row = 0;
                        derection = -1;
                    }
                } else {
                    row = row + 1;
                    col = col - 1;
                    if (row >= n) {
                        col = col + 2;
                        row = row - 1;
                        derection = 1;
                    } else if (col < 0) {
                        col = 0;
                        derection = 1;
                    }
                }
            }
        }
    }
}
