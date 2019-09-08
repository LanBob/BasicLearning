package com.lusr.forwin.designPattern.factory.FactoryMethods.basic;

public class ProductBFactory implements IFactory{
    @Override
    public IProduct getProduct() {
        return new ProductB();
    }
}
