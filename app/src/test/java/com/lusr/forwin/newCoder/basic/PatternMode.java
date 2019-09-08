package com.lusr.forwin.newCoder.basic;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMode {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            System.out.println(findStr(str));
        }
    }

    private static String findStr(String str) {
        String result = null;
        int len = str.length();
//        System.out.println(len);
        int lastIndex = -1;
        //[\img]
        for (int i = len - 1; i >= 0; i--) {
            if (str.charAt(i) == ']' && str.charAt(i - 1) == 'g'
                    && str.charAt(i - 2) == 'm'
                    && str.charAt(i - 3) == 'i'
                    && str.charAt(i - 4) == '\\' &&
                    str.charAt(i - 5) == '[') {
                lastIndex = i;
                break;
            }
        }
//        System.out.println(lastIndex);
        if (lastIndex != -1) {
            int beginIndex = -1;
            for (int i = lastIndex; i >= 0; i--) {
                if (str.charAt(i) == ']'
                        && str.charAt(i - 1) == 'g'
                        && str.charAt(i - 2) == 'm'
                        && str.charAt(i - 3) == 'i'
                        && str.charAt(i - 4) == '[') {
                    beginIndex = i - 4;
                    break;
                }
            }
            if (beginIndex != -1) {
                result = str.substring(beginIndex, lastIndex + 1);
            }
        }
        return result;
    }
}
