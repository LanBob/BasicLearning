package com.lusr.forwin.qiuckheapSort;

import java.util.Stack;

/**
 * Created by Lusq
 * Date: 2019/8/27
 * description:
 */
public class QiuckSort {
    public static void main(String[] args){
        int a[] = new int[]{4,1,5,3,7,6};
        qiuckSort(a,0,a.length - 1);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    private static void qiuckSort(int a[],int left,int right){
        if(left >= right){
            return;
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(right);
        stack.push(left);
        while (!stack.isEmpty()){
            int tmpLeft = stack.pop();
            int tmpRight = stack.pop();
            int index = partition(a,tmpLeft,tmpRight);
            if(index - 1 > tmpLeft){
                stack.push(index - 1);
                stack.push(tmpLeft);
            }
            if(index + 1 < tmpRight){
                stack.push(tmpRight);
                stack.push(index + 1);
            }
        }
    }

//    private static void qiuckSort(int a[],int left,int right){
//        if(left >= right){
//            return;
//        }
//        int partIndex = partition(a,left,right);
//        qiuckSort(a,left,partIndex - 1);
//        qiuckSort(a,partIndex + 1, right);
//    }

    private static int partition(int[] a, int left, int right) {
        int tmp = a[left];
        int tmpLeft = left;
        int tmpRight = right;
        while (tmpLeft < tmpRight){
            while (tmpLeft < tmpRight && a[tmpRight] >= tmp) {
                tmpRight--;
            }
            while (tmpLeft < tmpRight && a[tmpLeft] <= tmp) {
                tmpLeft++;
            }
            if(tmpLeft < tmpRight){
                int t = a[tmpLeft];
                a[tmpLeft] = a[tmpRight];
                a[tmpRight] = t;
            }
        }
        a[left] = a[tmpLeft];
        a[tmpLeft] = tmp;
        return tmpLeft;
    }
}
