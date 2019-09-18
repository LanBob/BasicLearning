package com.lusr.forwin.FanXing;

public class TypeClass {
    public static void main(String[] args) {
        //这种方式能有效防止出现什么东西都可以传
        A<Integer> integerA = new A<>();
        integerA.init(1);
        System.out.println(integerA.getA().getClass());

        //这总方式不能限制,可以传Object，总结就是，声明什么是什么。
        A in = new A<>();
        in.init(1);
        System.out.println(in.getA().getClass());


        //这种也可以实现限定
        GeneratorImpl<String> generator = new GeneratorImpl<>();

        //这个也一定可以限定String类
        StringGeneratorImpl stringGenerator = new StringGeneratorImpl();
        stringGenerator.next();
    }


    /**
     * 第一种使用方式：泛型类
     *
     * @param <T>
     */
    static class A<T> {
        public T a;

        void init(T a) {
            this.a = a;
        }

        T getA() {
            return a;
        }
    }


    interface Generator<T> {
        T next();
    }

    /**
     * 实现泛型接口，不传入泛型的具体类
     *
     * @param <T>
     */
    static class GeneratorImpl<T> implements Generator<T> {


        @Override
        public T next() {
            return null;
        }

        /**
         * 使用通配符 ? ，这里的showKeyValue可以传入任何的类型
         *
         * @param obj
         */
        public void showKeyValue1(Generator<?> obj) {
            System.out.println("泛型测试key value is " + obj.toString());
        }
    }

    /**
     * 传入了泛型接口的具体泛型类
     */
    static class StringGeneratorImpl implements Generator<String> {

        @Override
        public String next() {
            return null;
        }
    }
}
