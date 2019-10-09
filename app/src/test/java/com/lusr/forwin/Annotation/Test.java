package com.lusr.forwin.Annotation;

import java.util.Set;

import androidx.annotation.NonNull;

/**
 * 注解有override、suppressWarnings
 * 例子：
 *
 * @Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE})
 * @Retention(RetentionPolicy.SOURCE) public @interface SuppressWarnings {
 * String[] value();
 * }
 * <p>
 * 1、这里的 @interface 代表继承了Annotation接口,而这个实现是就是贴标签
 * 2、里面的方法String[] value() 抽象方法，在注解中标示属性
 * 3、@Target和@Retention是元注解，注解中的注解
 * 4、元注解有四种：Target 、 Retention、Document、Inherited（继承）
 * 5、Retention标示保存在那个时期的值，封装在RetentionPllicy枚举类中，一般自定义的注解使用Runttion
 * 源代码通过编译得到字节码时期,运行操作进入RUNTIME时期
 * 源文件时期 SOURCE  注解只存在于源文件中，字节码和运行时期不存在
 * 字节码时期 CLASS 可以存在于源文件和字节码中，不存在JVM中
 * 运行时期 RUNTIME 可以存在于源文件、字节码和JVM中
 * <p>
 * 6、Target标示可以贴在类、方法、构造器、字段上等，在ElementType枚举类中
 * 7、Document标签会保存到API文档中
 * 8、Inherited标注的标签可以被子类继承   也就是子类也会存在这个注解
 */

//贴上这个注解，就消除了所有的标黄的地方
@SuppressWarnings("all")
public class Test {

    public void test(@MyAnnotation("path") String a) {
        Set set = null;
    }

    @NonNull
    @Override
    public String toString() {
        return super.toString();
    }
}
