package com.lusr.forwin.base;

public class Premeters {

    String a = "123";

    public static void test(Premeters test) {
        test.a = "abc";
    }

    public static void main(String[] args) {
        //=================================改变对象的属性是可以的
        Premeters test1 = new Premeters();
        test1.a = "567";
        System.out.println(test1.a); //567

        test(test1);
        System.out.println(test1.a); //abc

        //============================================


        String testString = "testString";
        test(testString);
        System.out.println(testString);

        //============================================
        StringBuffer stringBuffer = new StringBuffer("StringBuffer");
        testStringBuffer(stringBuffer);
        System.out.println(stringBuffer);
    }

    /**
     * 相当于 str = testString;   而改变了str不会影响到testString
     * @param str
     */
    public static void test(String str)
    {
        str = "word";
    }


    /**
     * 提供了自我拓展的能力
     * @param str
     */
    public static void testStringBuffer(StringBuffer str)
    {
        str.append(" Method change it");
    }

}
