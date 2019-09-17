package com.lusr.forwin.base;

import java.util.Arrays;

/**
 * Created by Lusq
 * Date: 2019/8/30
 * description:
 */
public class BitCaculate {
    public static void main(String[] args) {

        //名称是，无符号右移，在值为正数的时候，与 >> 结果一致。
        //当值为负数的时候，>> 在最高位补1，而 >>> 在最高位补0，导致出现正数
        System.out.println(-15 >> 2);
        System.out.println(-15 >>> 30);
//        11110001 >> 2 = 11111100（还是一个负数，转换为十进制就是-4）
//        11110001 >>> 2 = 00111100（这变成了正数了，转换成十进制就是60）
//        这里因为是 32位，所以，-15右移30位的结果为： 000……110
    }

    public static void testSwitch(int value) {
        boolean isTrue = true;
        //需要char / byte / short / int / Character / Byte / Short / Integer /
        // String / enum
        switch (value) {
            case 1:
                break;
            default:
                break;
        }
    }
}
