package com.cd.test.designpattern.builder;

/**
 * custom
 * 
 */
public class Product_mine {
    private String field1;
    private String field2;
    private String field3;
    private String field4;

    public Product_mine() {
    }

    public String getField1() {
        return field1;
    }

    public Product_mine setField1(String field1) {
        this.field1 = field1;
        return this;
    }

    public String getField2() {
        return field2;
    }

    public Product_mine setField2(String field2) {
        this.field2 = field2;
        return this;
    }

    public String getField3() {
        return field3;
    }

    public Product_mine setField3(String field3) {
        this.field3 = field3;
        return this;
    }

    public String getField4() {
        return field4;
    }

    public Product_mine setField4(String field4) {
        this.field4 = field4;
        return this;
    }

    @Override
    public String toString() {
        return "Product_mine{" +
                "field1='" + field1 + '\'' +
                ", field2='" + field2 + '\'' +
                ", field3='" + field3 + '\'' +
                ", field4='" + field4 + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Product_mine product1 = new Product_mine();
        Product_mine product = product1.setField1("f1").setField2("f2").setField3("f3").setField2("f3");
        System.out.println(product);
        product.setField2("f2").setField4("f4");
        System.out.println(product);
    }
}

