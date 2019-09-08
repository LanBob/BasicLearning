package com.lusr.forwin.designPattern.factory.sampleFactory;

/**
 * Created by Lusq
 * Date: 2019/9/2
 * description:
 */
class Factory {
    static Product createProduct(String name) {
        switch (name) {
            case "A":
                return new ProductA();
            case "B":
                return new ProductB();
            case "C":
                return new ProductC();
            default:
                return null;
        }
    }
}
