package com.lusr.forwin.newCoder.basic;

public class FindInteger {

    public static void main(String[] args) {
        int[][] array = new int[][]{
                {1, 3, 4},
                {5, 6, 7},
                {8, 9, 10},
                {11,13,15}
        };
        System.out.println(Find(3, array));
    }

     static boolean Find(int target, int[][] array) {
        int x = array[0].length;
        int y = array.length;

        int tmpX = x - 1;
        int tmpY = 0;
        while (tmpX >= 0 && tmpY < y) {
            if (array[tmpY][tmpX] == target) {
                return true;
            } else if (array[tmpY][tmpX] < target) {
                tmpY++;
            } else {
                tmpX--;
            }
        }
        return false;
    }
}
