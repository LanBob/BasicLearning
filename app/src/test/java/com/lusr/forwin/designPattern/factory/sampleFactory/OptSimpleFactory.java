package com.lusr.forwin.designPattern.factory.sampleFactory;

class OptSimpleFactory {

    /**
     * 解决违反 开闭原则
     * @param clz 产品的类
     * @return
     */
    public static Object createProduct(Class clz) {
        Product product = null;
        try {
            product = (Product) Class.forName(clz.getName()).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return product;
    }

}