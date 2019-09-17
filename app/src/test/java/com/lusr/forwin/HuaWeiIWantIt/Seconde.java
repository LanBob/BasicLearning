package com.lusr.forwin.HuaWeiIWantIt;

import java.util.Scanner;
import java.util.Stack;

public class Seconde {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            String[] strings = str.split(" ");
            Stack<String> stack = new Stack<>();
            for (int i = 0; i < strings.length; i++) {
                stack.push(strings[i]);
            }
            String tmp;
            while (!stack.isEmpty()) {
                tmp = stack.pop();
                solve(tmp);
            }
        }
    }

    ///这里是一个字符串
    private static void solve(String tmp) {
        if (" ".equals(tmp)) {
            return;
        }

        int len = tmp.length();

        int flag = len - 1;
        int left = len - 1;
        int right = left;
        for (int i = len - 1; i >= 0; i--) {
            char indexChar = tmp.charAt(i);
            if (i == flag && (indexChar == '-' || !isRight(indexChar))) {
                flag--;
                right--;
                System.out.println();
                continue;
            }

            if (i - 1 >= 0 && indexChar == '-' && tmp.charAt(i - 1) == '-') {
                for (int j = i + 1; j <= right; j++) {
                    if (!(j == right && tmp.charAt(j) == '-'))
                        System.out.print(tmp.charAt(j));
                    if (j == right) {
                        System.out.println(" ");
                    }
                }
                right = i-1;
            }

            if (isRight(indexChar)) {
                continue;
            }

            if (!isRight(indexChar)) {
                for (int j = i + 1; j <= right; j++) {
                    if (!(j == right && tmp.charAt(j) == '-'))
                        System.out.print(tmp.charAt(j));
                    if (j == right) {
                        System.out.println(" ");
                    }
                }
                right = i-1;
            }

        }
    }

    static boolean isRight(char c) {
        if (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z' || c >= '0' && c <= '9' || c == '-') {
            return true;
        }
        return false;
    }
}
