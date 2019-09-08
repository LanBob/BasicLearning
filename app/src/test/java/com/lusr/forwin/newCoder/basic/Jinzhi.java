package com.lusr.forwin.newCoder.basic;

import java.util.Scanner;

public class Jinzhi {
    public static void main(String[] args) {
        long num, count;
        Scanner scanner = new Scanner(System.in);
        num = scanner.nextInt();
        count = scanner.nextInt();

        StringBuilder stringBuilder = new StringBuilder("");

        while (num != 0) {
            long flag = getBitNum(num, count);
            stringBuilder.append(flag);
            num = num / count;
        }
        System.out.println(stringBuilder.reverse());

    }

    private static long getBitNum(long leftNum, long count) {
        return leftNum % count;
    }
}
