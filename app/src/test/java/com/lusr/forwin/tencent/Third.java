package com.lusr.forwin.tencent;

import java.util.Scanner;

public class Third {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int min = -1;
        int n = scanner.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
            if (a[i] < min || min == -1) {
                min = a[i];
            }
        }
        solve(a, n, min);
    }

    private static void solve(int[] a, int n, int min) {
        for (int i = 0; i < n; i++) {
            a[i] = a[i] - min;
        }
        int all = 0;

        while (true) {

            int count = 0;
            int max = -1;
            int maxFlag = 0;

            for (int i = 0; i < n; i++) {
                if (a[i] <= 0) {
                    count++;
                }
                if (max < a[i]) {
                    max = a[i];
                    maxFlag = i;
                }
            }

            if (count >= n) {
                break;
            }


            int resultCount = 0;
            int resultLeft = 0;
            int resultRight = 0;

            for (int i = 0; i < n; ) {
                int tmp = -1;
                int tmpLeft = 0;
                int tmpRight = 0;
                while (a[i] <= 0) {
                    ++i;
                }
                tmpLeft = i;

                int j = 0;
                for (j = tmpLeft; j < n; j++) {
                    if (a[j] > 0) {
                        tmp++;//计数
                        tmpRight = j;
                    } else {
                        break;
                    }
                }

                if (resultCount < tmp) {
                    resultCount = tmp;
                    resultLeft = tmpLeft;
                    resultRight = tmpRight;
                }
                i = j;
                if (tmpLeft == tmpRight) {
                    ++i;
                }
            }

            if (resultCount < max) {
                a[maxFlag] = 0;
            } else {
                for (int i = resultLeft; i <= resultRight; i++) {
                    a[i] = a[i] - 1;
                }
            }
            all++;
        }
        System.out.println(all + min);
    }
}
