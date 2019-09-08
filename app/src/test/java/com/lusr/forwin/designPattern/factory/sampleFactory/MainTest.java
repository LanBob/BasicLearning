package com.lusr.forwin.designPattern.factory.sampleFactory;

/**
 * Created by Lusq
 * Date: 2019/9/2
 * description:
 */
public class MainTest {

    public static void main(String[] args) {
        Product product = Factory.createProduct("B");
        product.show();

        //只需改变这个Class的类
        Product product1 = (Product) OptSimpleFactory.createProduct(ProductB.class);
        product1.show();
    }
}
