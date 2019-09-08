package com.lusr.forwin.classload;

/**
 * Created by Lusq
 * Date: 2019/8/28
 * description:
 */
public class InitDemo {
    public static void main(String[] args){
        System.out.println("aa");
    }



    static
    {
        System.out.println("静态方法");
    }

//    如果不加下面这个，结果是： 静态方法 \n aa，即类不会被实例化。
//    如果加上这个，那么根据这里的static的顺序，会先执行上面的静态代码块，后面才会执行
//    类变量的初始化,所以，加上的结果为：静态方法 \n普通fangfa \n 构造方法被调用 \n aa
//    而这里的类变量的初始化会伴随着new对象，调用对象初始化方法，此时触发普通代码块、类成员变量的初始化
    static InitDemo initDemo = new InitDemo();

    {
        System.out.println("普通fangfa");
    }

    InitDemo(){
        System.out.println("构造方法被调用");
    }
}
