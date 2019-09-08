package com.lusr.forwin.classload;

/**
 * 总结：类加载的步骤：
 * 加载、连接（包括验证、准备和解析）、初始化、使用、卸载
 *
 * 验证阶段是：校验字节码是否存在风险，是否符合JVM的规范
 * 准备阶段：最重要的是完成类变量的准备，即
 * 如果有static代码块或者static修饰的类变量n
 * 那么会按照顺序合并成为一个 类初始化方法，并按顺序执行
 *
 * 解析阶段不一定会有
 *
 * 初始化阶段：主要是触发初始化的条件有5个
 *
 * 一般来说当 JVM 遇到下面 5 种情况的时候会触发初始化：
 * 遇到 new、getstatic、putstatic、invokestatic 这四条字节码指令时，如果类没有进行过初始化，
 则需要先触发其初始化。生成这4条指令的最常见的Java代码场景是：使用new关键字实例化对象的时候、
 读取或设置一个类的静态字段（被final修饰、已在编译器把结果放入常量池的静态字段除外）的时候，
 以及调用一个类的静态方法的时候。

 * 使用 java.lang.reflect 包的方法对类进行反射调用的时候，如果类没有进行过初始化，则需要先触发其初始化。
 *
 * 当初始化一个类的时候，如果发现其父类还没有进行过初始化，则需要先触发其父类的初始化。
 *
 * 当虚拟机启动时，用户需要指定一个要执行的主类（包含main()方法的那个类），虚拟机会先初始化这个主类。
 * 当使用 JDK1.7 动态语言支持时，如果一个 java.lang.invoke.MethodHandle实例最后的解析结果 REF_getstatic,REF_putstatic,REF_invokeStatic 的方法句柄，并且这个方法句柄所对应的类没有进行初始化，则需要先出触发其初始化。
 *
 *
 * Created by Lusq
 * Date: 2019/8/28
 * description:
 */
public class Book {
    public static void main(String [] args){
        //由于触发了类初始化的条件：拥有main方法的类会被有限初始化
        //所以这个Book会被初始化。但是类加载后，作为字节码存在，并不存在构造器这样的概念
        //所以构造函数不会被调用
        System.out.println("main");

        //但是有 类初始化方法 和 对象初始化方法
        //类初始化方法是收集类变量赋值语句、静态代码块 构成的。
        //类初始化方法在类初始化的时候被调用

        // 区别于 对象初始化方法，收集成员变量的赋值语句、普通代码块，最后收集构造函数的代码，最终组成对象初始化方法
        //一般对象初始化方法是在实例化类对象的时候被调用的
    }

    Book(){
        System.out.println("Book 构造器");
    }

    private static int flag = 11;
    private int flagNormal = 10;

    static {
        System.out.println("Book 静态代码块, flag = " + flag );
    }

    {
        System.out.println("Book 普通代码块");
    }

}
