package com.lusr.forwin.designPattern.factory.FactoryMethods.basic;

public class ProductAFactory implements IFactory{
    @Override
    public IProduct getProduct() {
        return new ProductA();
    }
}
