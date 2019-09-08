package com.lusr.forwin.newCoder.basic;

import java.util.Scanner;
import java.util.Stack;

public class Kuohao {
    public static void main(String[] args) {
        String str = null;
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            str = scanner.nextLine();
            char[] chars = str.toCharArray();
            Stack<Integer> stack = new Stack<>();

            boolean flag = true;

            int len = chars.length;
            for (int i = 0; i < len; i++) {
                if(stack.isEmpty()){
                    stack.push(getInt(chars[i]));
                }else {
                    int next = getInt(chars[i]);
//                    System.out.print("next =" + next + ",top = " + stack.peek());
                    if(next < 0){
                        if(stack.peek() != -next){
                            flag = false;
                            break;
                        }else {
                            stack.pop();
                        }
                    }else {
                        stack.push(getInt(chars[i]));
                    }
                }
            }

            if(flag && stack.isEmpty()){
                System.out.println("true");
            }else {
                System.out.println("false");
            }
        }
    }

    static int getInt(char c) {
        switch (c) {
            case '(':
                return 1;
            case ')':
                return -1;
            case '[':
                return 2;
            case ']':
                return -2;
            case '{':
                return 3;
            case '}':
                return -3;
            default:
                return 0;
        }
    }
}
