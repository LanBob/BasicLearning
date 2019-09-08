package com.lusr.forwin.classload;

/**
 * Created by Lusq
 * Date: 2019/8/28
 * description:
 */
public class InitAndConstruct {
    public static void main(String[] args){
        /**
         * 解释：
         * 想要new一个对象，要先完成初始化，初始化之前的，加载和连接阶段要先完成。
         * 而静态方法是在连接阶段的准备阶段完成的，所以，首先回去进行准备。
         * 而准备阶段发现son的父类没有进行初始化，所以首先进行Son的父类Fathers的初始化
         * 而进行父类Fathers的初始化的时候，发信啊Grand没有进行 初始化，所以首先要进行Grand
         * 的初始化
         *
         *
         * 而完成了这些初始化之后，由于继承的关系，Son的构造器的第一句，首先要去调用父类的构造方法
         * 而Fathers的构造方法首先又会去调用Grand的构造方法，所以有这样的结果。
         */
        new Son();
    }
}

class Sons extends Fathers{
    static {
        System.out.println("儿子静态");
    }
    Sons(){
        System.out.println("儿子构造器");
    }
}
class Fathers extends Grand{
    static {
        System.out.println("父亲静态");
    }
    Fathers(){
        System.out.println("父亲构造器");
    }
}

class Grand{
    static {
        System.out.println("爷爷静态");
    }

    Grand(){
        System.out.println("爷爷构造器");
    }
}
