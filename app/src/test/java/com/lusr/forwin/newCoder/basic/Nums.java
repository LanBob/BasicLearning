package com.lusr.forwin.newCoder.basic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Nums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] a = new int[32];
            Arrays.fill(a, 0);
            int tmp = 0;
            for (int i = 0; i < n; i++) {
                tmp = scanner.nextInt();
                int bit = 1;
                for (int j = 0; j < 32; ++j) {
                    if((bit & tmp) != 0 ){
                        a[j]++;
                    }
                    bit <<= 1;
                }
//                for (int j = 0; j <= 31; j++) {
//                    System.out.print(a[j] + ",");
//                }
//                System.out.println();
            }

            int result = 0;
            int bit = 1;
            for (int i = 0; i < 32; i++) {
//                System.out.print(a[i] + ",");
                a[i] = a[i] % 3;
                if(a[i] != 0){
                    result += bit << (i);
                }
            }
            System.out.println(result);
        }
    }
}
