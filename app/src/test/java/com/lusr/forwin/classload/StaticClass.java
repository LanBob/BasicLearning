package com.lusr.forwin.classload;

/**
 * Created by Lusq
 * Date: 2019/8/28
 * description:
 */
public class StaticClass {

    public static void main(String[] args){
        //由于Son没有受到触发初始化的的条件，所以没有进行初始化
        //Son.flag是Father类的static变量，即类变量，即触发触发初始化的条件：get static
        //此时会去初始化Father。而加载机制规定，如果一个类要进行初始化时，发现父类没有进行初始化。
        //那么先摇进行父类的初始化。
        System.out.println(Son.flag);
    }
}
class Son extends Father{
    static {
        System.out.println("son 静态");
    }
    public Son(){
        System.out.println("son 构造器");
    }
}
class Father extends GrandPa{
    static {
        System.out.println("爸爸静态");
    }

    public static int flag = 11;

    public Father(){
        System.out.println("Father构造器");
    }
}

class GrandPa{
    static {
        System.out.println("grandPa 静态");
    }
    public GrandPa(){
        System.out.println("爷爷构造器");
    }
}
