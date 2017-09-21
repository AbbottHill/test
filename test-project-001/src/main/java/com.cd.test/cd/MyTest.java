
package test.com.cd;

import com.googlecode.aviator.AviatorEvaluator;
import javafx.scene.chart.PieChart;
import org.apache.commons.lang3.StringUtils;

import javax.sound.midi.Soundbank;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

public class MyTest {
    public static void main(String[] args) {
        new MyTest();
    }

    public MyTest() {
        testGooeleAviator.expressionEngine();

        //        testCollections.test_map();
    }

    static void myPrint(Object obj) {
        System.out.println("-----> " + obj);
    }
}

class MyToos{

    /**
     * @param str
     * @return
     * @throws NullPointerException if str is null
     */
    static boolean isStringDigit(String str) throws NullPointerException{
        return Pattern.matches("-?\\d+\\.?\\d+", str);
    }

    static void copyFile(String filePath) {
//        FileInputStream fileInputStream = null;
//        try {
//            fileInputStream = new FileInputStream(filePath);
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            fileInputStream.close();
//        }
    }
}

class testCollections {
    static void test_map() {
        Map map = new HashMap(2);//initialCapacity
        map.put("1", 1);
        map.put("2", 2);
        map.put("3", 3);
        System.out.println(map);
    }

}

/**
 * commons-lang3
 */
class testApacheCommonsLang {
    static void arr2String() {
        List list = new ArrayList();
        list.add("abc");
        list.add("123");
        Map map = new HashMap();
        list.add(map);
        map.put("1", 1);
        Iterator iterator = list.iterator();
        System.out.println(StringUtils.join(iterator, ","));;
    }
}

/**
 * aviator
 */
class testGooeleAviator {
    static void expressionEngine() {
        Long result = (Long) AviatorEvaluator.execute("1+2+3");
        MyTest.myPrint(result);
    }
}




