package com.lusr.forwin.newCoder.basic;

import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, target;
        n = scanner.nextInt();
        target = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; ++i) {
            a[i] = scanner.nextInt();
        }

        int index = getIndex(target, a);
        if (index != -1) {
            int left = index;
            int right = index;
            while (left >= 0 && a[left] == target) {
                left--;
            }
            while (right < a.length && a[right] == target) {
                right++;
            }
            ++left;
            --right;
            System.out.println("[" + left + "," + right + "]");
        } else {
            System.out.println("[-1,-1]");
        }
    }

    static int getIndex(int target, int a[]) {
        int len = a.length - 1;
        int left = 0;
        int right = len;
        int mid = len / 2;
        while (a[mid] != target && left < right) {
            if (a[mid] > target) {
                right = mid;
            } else {
                left = mid;
            }
            mid = (left + right) / 2;
        }
        if (a[mid] == target)
            return mid;
        return -1;
    }
}
