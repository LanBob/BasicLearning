package com.lusr.forwin.newCoder.tree;

import java.util.Scanner;

public class BST {
    public static void main(String[] args) {
        int a[] = new int[]{1, 4, 9, 10, 5};
        System.out.println(VerifySquenceOfBST(a));
    }

    private static boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence.length <= 0) return false;
        return judge(sequence, 0, sequence.length - 1);
    }

    private static boolean judge(int a[], int l, int r) {
        if (l >= r) {
            return true;
        }
        int tmp = l;
        while (a[tmp] < a[r] && tmp < r) {
            tmp++;
        }

        for (int i = tmp; i < r; i++) {
            if (a[tmp] < a[r]) {
                return false;
            }
        }
        return judge(a, l, tmp - 1) && judge(a, tmp + 1, r - 1);
    }
}
