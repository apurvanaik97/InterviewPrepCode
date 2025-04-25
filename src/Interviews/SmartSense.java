package Interviews;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SmartSense {
    public static void main(String[] args) {
//        ATM Machine
//
//        2000, 1000, 500, 300, 200, 100
//
//        Withdrawl --> 4000
//        O/p -> 2000 -> 2
//
//
//        3500
//        2000 -> 1
//        1000 ->1
//        500 -> 1
        printMinNotes(3600);

    }

    private static void printMinNotes(int i) {

        System.out.println("Output will be ");

        Map<Integer, Integer> countNotes = new HashMap<>();
        countNotes.put(2000, 0);
        countNotes.put(1000, 0);
        countNotes.put(500, 0);
        countNotes.put(100, 0);
        countNotes.put(300, 0);
        int remain = 0;

        List<Integer> notes = Arrays.asList(2000, 1000, 500, 300, 100);

//        for (Integer note : notes) {
//            if (i > 100)
//                i = i % note;
//        }
        while (i > 100) {
            if (i >= 2000) {
                countNotes.put(2000, countNotes.get(2000) + 1);
                i = i % 2000;
            }
            if (i >= 1000) {
                countNotes.put(1000, countNotes.get(1000) + 1);
                i = i % 1000;
            }
            if (i >= 500) {
                countNotes.put(500, countNotes.get(500) + 1);
                i = i % 500;
            }
            if (i >= 300) {
                countNotes.put(300, countNotes.get(300) + 1);
                i = i % 300;
            }
            if (i >= 200) {
                countNotes.put(200, countNotes.get(200) + 1);
                i = i % 200;
            }
            if (i >= 100) {
                countNotes.put(100, countNotes.get(100) + 1);
                i = i % 100;
            }
        }

        System.out.println("Following are the notes");
        countNotes.forEach((k,v) -> System.out.println("Note " + k +" value =" + v));
    }
}
