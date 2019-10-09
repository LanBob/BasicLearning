package com.lusr.forwin.newCoder.basic;

public class DpBasic {
    public static void main(String[] args) {
        int[] a = {6, -3, -2, 7, -15, 1, 2, 2};
        int[] dp = new int[a.length];
        dp[0] = a[0];
        int max = 0x80000000;
        for (int i = 1; i < a.length; i++) {
            dp[i] = Math.max(a[i],dp[i-1] + a[i]);
            max = Math.max(max,dp[i]);
        }
        System.out.println(max);
    }
}
