package com.lusr.forwin.designPattern.factory.FactoryMethods.opt;

public class OptFactory<T> extends IFactory {

    @Override
    public T createFromFactory(Class clz) {
        IProduct product = null;
        try {
            product = (IProduct) Class.forName(clz.getName()).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return (T) product;
    }

}
