package com.cd.test.base;

/**
 * 值传递是指在调用函数时将实际参数复制一份传递到函数中，这样在函数中如果对参数进行修改，将不会影响到实际参数。
 */
public class ValuePropagation {

    public static void main(String[] args) {
        StringBuilder a = new StringBuilder("A");
        StringBuilder b = new StringBuilder("B");
        operation(a, b);
        System.out.println(a + "." + b);  //AB.B
    }

    static void operation(StringBuilder s1, StringBuilder s2) {
        s1.append(s2);
        s2 = s1;
    }

}

/**
 * about string array
 */
class ValuePropagation1 {
    String str = "1";
    String[] strArr = {"2"};
    public static void main(String[] args)
    {
        ValuePropagation1 app = new ValuePropagation1();
        app.operate(app.str, app.strArr);
        System.out.println(app.str +app.strArr[0]);
    }
    static void operate(String str, String[] strArr)
    {
        str = new String("3");
        strArr[0] = new String("4");
    }
}
