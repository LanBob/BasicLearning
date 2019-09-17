package com.lusr.forwin.IDontWant;

import java.util.Scanner;

public class Gift {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str;
        while (scanner.hasNext()) {
            str = scanner.nextLine();
            int len = str.length();
            int count = 0;
            for (int i = 0; i < len; i++) {
                if(str.charAt(i) == '('){
                    count++;
                }else if(str.charAt(i) == ')'){
                    count--;
                }else if (str.charAt(i) == '0') {
                    break;
                }
            }
            System.out.println(count);
        }
    }
}
