package com.lusr.forwin.newCoder.basic;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Sum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, m;
        while (scanner.hasNext()) {
            Map<Integer, Integer> map = new HashMap<>();
            n = scanner.nextInt();
            m = scanner.nextInt();
            int[] a = new int[n];
            int tmp;
            for (int i = 0; i < n; i++) {
                tmp = scanner.nextInt();
                a[i] = tmp;
                map.put(tmp, i);
            }

            boolean flag = false;
            for (int i = 0; i < n; i++) {
                if (map.containsKey(m - a[i]) && map.get(m - a[i]) != i) {
                    flag = true;
                    System.out.println(i+" "+map.get(m-a[i]));
                    break;
                }
            }
            if(!flag){
                System.out.println("false");
            }
        }
    }
}
