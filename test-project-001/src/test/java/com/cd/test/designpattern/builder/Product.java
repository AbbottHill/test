package com.cd.test.designpattern.builder;

/**
 * 注意Product 是不可变得，所有的默认参数值都单独放在一个地方。builder的setter方法返回builder本身。以便可以把连接起来
 * vs
 * 重叠构造器模式：构造器调用通常需要许多你本不想设置的参数，但还是不得不为它们传递值，创建使用代码会很难写，并且较难以阅读
 *      Person person = new Persion(1, "李四", 20, "男", "18800000000", "China", "测试使用重叠构造器模式");
 * vs
 * JavaBeans模式：因为构造过程被分到了几个调用中，在构造过程中JavaBean可能处于不一致的状态
 *      Person person = new Person();
 *      person.setId(1);
 *      person.setName("李四");
 */
public class Product {
    private String field1;
    private String field2;
    private String field3;
    private String field4;

    private Product(Builder builder) {
        field1 = builder.field1;
        field2 = builder.field2;
        field3 = builder.field3;
        field4 = builder.field4;
    }

    public static class Builder {
        private String field1;
        private String field2;
        private String field3;
        private String field4;

        public Builder setField1(String field1) {
            this.field1 = field1;
            return this;
        }

        public Builder setField2(String field2) {
            this.field2 = field2;
            return this;
        }

        public Builder setField3(String field3) {
            this.field3 = field3;
            return this;
        }

        public Builder setField4(String field4) {
            this.field4 = field4;
            return this;
        }

        public Product builder() {
            return new Product(this);
        }
    }

    @Override
    public String toString() {
        return "Product{" +
                "field1='" + field1 + '\'' +
                ", field2='" + field2 + '\'' +
                ", field3='" + field3 + '\'' +
                ", field4='" + field4 + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Product pd = new Builder().setField1("f1").setField2("f2").builder();
        System.out.println(pd);
    }

}
