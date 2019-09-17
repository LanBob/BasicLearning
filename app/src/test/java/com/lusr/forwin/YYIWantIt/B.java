package com.lusr.forwin.YYIWantIt;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine();
        String[] strings = str.split(" ");
        int target = Integer.valueOf(strings[strings.length - 1]);
        int[] a = new int[strings.length - 1];
        for (int i = 0; i < a.length; i++) {
            a[i] = Integer.valueOf(strings[i]);
        }
        int index = find(a, target);
        if (a[index] <= target) {
            while (index < a.length && a[index] <= target) {
                //System.out.println("++++++" + index);
                index++;
            }
            System.out.println(index - 1);
        } else {
            while (index >= 0 && a[index] > target) {
                //System.out.println("---------" + index);
                index--;
            }
            System.out.println(index);
        }
    }

    private static int find(int[] a, int target) {
        int left = 0;
        int right = a.length-1;
        int index = 0;
        while (left < right) {
            int mid = (left + right) / 2;
            if(mid == left){
                break;
            }
            if (a[mid] == target) {
                break;
            } else if (a[mid] > target) {
                right = mid;
            } else {
                left = mid;
            }
        }
        index = (left + right) / 2;
        return index;
    }
}
