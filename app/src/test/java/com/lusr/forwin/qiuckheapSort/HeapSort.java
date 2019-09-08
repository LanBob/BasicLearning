package com.lusr.forwin.qiuckheapSort;

/**
 * Created by Lusq
 * Date: 2019/8/27
 * description:
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] a = new int[]{1, 7, 4, 6, 5, 3, 8};
        heapSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    private static void heapSort(int[] a) {
        int len = a.length;
        for (int i = (len - 2) / 2; i >= 0; --i) {
           adjustDown(a,i,len);
        }

        for (int i = len-1; i > 0; --i){
            int t = a[0];
            a[0] = a[i];
            a[i] = t;
            adjustDown(a,0,i);
        }
    }

    private static void adjustDown(int[] a, int parentIndex, int len) {
        int tmp = a[parentIndex];
        int childIndex = parentIndex * 2 + 1;
        while (childIndex < len){

            if(childIndex + 1 < len && a[childIndex +1] > a[childIndex]){
                childIndex++;
            }

            if(a[childIndex] < tmp){
                break;
            }
            a[parentIndex] = a[childIndex];
            parentIndex = childIndex;
            childIndex = parentIndex * 2 + 1;
        }
        a[parentIndex] = tmp;
    }


}
