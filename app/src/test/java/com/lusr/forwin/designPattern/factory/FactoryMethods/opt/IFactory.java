package com.lusr.forwin.designPattern.factory.FactoryMethods.opt;

public abstract class IFactory<T> {
    public abstract T createFromFactory(Class clz);
}
