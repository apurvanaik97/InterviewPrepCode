package MultiThreading;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Parent {
    public static void main(String[] args) {
        List<String> list = Collections.synchronizedList(new ArrayList<>());
        synchronized (list) {
            for (String item : list) {
                System.out.println(item);
                list.add("D");
            }
        }    }

}

