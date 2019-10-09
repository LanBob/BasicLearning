package com.lusr.forwin.newCoder.sort;

import java.lang.reflect.GenericArrayType;
import java.util.ArrayList;
import java.util.Arrays;

public class TopK {
    public static void main(String[] args) {
        System.out.println(0x80000000);
        int[] a = {4, 5, 1, 6, 2, 7, 3, 8};
        System.out.println(Arrays.toString(GetLeastNumbers_Solution(a, 4).toArray()));

    }

    public static ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        if (input.length < k) {
           return new ArrayList<>();
        }

        int[] a = new int[k];
        for (int i = 0; i < k; i++) {
            a[i] = input[i];
        }
        heapSort(a);

        for (int i = k; i < input.length; i++) {
            if (a[0] > input[i]) {
                a[0] = input[i];
                adjustDown(a, 0, a.length - 1);
            }
        }

        for (int i = a.length - 1; i >= 0; i--) {
            int t = a[i];
            a[i] = a[0];
            a[0] = t;
            adjustDown(a, 0, i);
        }
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            integers.add(a[i]);
        }
        return integers;
    }

    static void heapSort(int[] a) {
        int len = a.length - 1;
        for (int i = (len - 2) / 2; i >= 0; i--) {
            adjustDown(a, i, len);
        }
    }

    static void adjustDown(int[] a, int parent, int len) {
        int child = parent * 2 + 1;
        int tmp = a[parent];
        while (child <= len) {
            if (child + 1 <= len && a[child + 1] > a[child])
                child++;
            if (a[child] < a[parent]) {
                break;
            }
            a[parent] = a[child];
            parent = child;
            child = parent * 2 + 1;
        }
        a[parent] = tmp;
    }


}
