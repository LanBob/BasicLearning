package com.lusr.forwin.newCoder.basic;

//String[] st = str.split(" "); 如果没有" "进行分割，那么返回的是整个字符串
//否则返回的是各个分组
public class EmptyString {
    public static void main(String[] args) {
        String str = "We Are Happy";
        System.out.println(replaceSpace(new StringBuffer(str)));
    }

    static String replaceSpace(StringBuffer str) {
        int len = str.length();
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (str.charAt(i) == ' ') {
                count++;
            }
        }

        if (count == 0) {
            return str.toString();
        }

        char[] chars = new char[len + count * 2];

        int index = len + count * 2 - 1;
        for (int i = len - 1; i >= 0; --i) {
            if (' ' == str.charAt(i)) {
                chars[index--] = '0';
                chars[index--] = '2';
                chars[index--] = '%';
            } else {
                chars[index--] = str.charAt(i);
            }
        }
        return new String(chars);
    }
}
