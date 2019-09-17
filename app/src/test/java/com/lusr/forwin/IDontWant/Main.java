package com.lusr.forwin.IDontWant;

import java.io.*;

/**
 * Welcome to vivo !
 */

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputStr = br.readLine();
        int input[] = parseInts(inputStr.split(" "));
        int output = solution(input);
        System.out.println(output);
    }

    private static int[] parseInts(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return new int[0];
        }
        int[] intArr = new int[strArr.length];
        for (int i = 0; i < intArr.length; i++) {
            intArr[i] = Integer.parseInt(strArr[i]);
        }
        return intArr;
    }

    private static int solution(int[] input) {

        int flag = 0;
        int score = 0;
        while (flag != input.length-2) {
            flag = 0;
            int max = -1;
            int count = 1;
            int left = 0;
            int right = 0;
            int tmpLeft = 0;
            int tmpRight = 0;

            for (int i = 0; i < input.length-1; i++) {
                if (input[i] == -1) {
                    flag++;
                    continue;
                }

                if (input[i] == input[i + 1]) {
                    count++;
                    tmpRight = i;
                    if (count > max) {
                        max = count;
                        left = tmpLeft;
                        right = tmpRight;
                    }
                } else {
                    count = 0;
                    tmpLeft = i;
                    tmpRight = i;
                }
            }
            for (int i = left; i < right; i++) {
                input[i] = -1;
            }
            score += count* count;


            for (int i = 0; i < input.length; i++) {
                System.out.print(input[i] + " ");
            }
            System.out.println();
        }
        return score;
    }
}
class Node{
    char c;
    int index;
    //(((0)))
    //(()0())
}