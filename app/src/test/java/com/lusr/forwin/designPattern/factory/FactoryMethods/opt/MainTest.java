package com.lusr.forwin.designPattern.factory.FactoryMethods.opt;

public class MainTest {

    /**
     * 好像这种方式也没有违反工厂方法
     * @param args
     */
    public static void main(String[] args) {
        OptFactory factory = new OptFactory();
        IProduct product = (IProduct) factory.createFromFactory(ProductB.class);
        product.commonMethod();
    }
}
