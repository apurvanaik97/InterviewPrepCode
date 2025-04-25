package Interviews;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BillDesk {
    public static void main(String[] args) {
        System.out.println("Hello Bill Desk");

//a= 1, 3, 5, 7, 9
//
//b= 2, 3, 4, 5, 6, 8, 10


        int[] a = new int[]{
                1, 3, 3, 5, 7, 9
        };

        int[] b = new int[]{
                2, 3, 3, 4, 5, 6, 8, 10
        };

        System.out.println(common(a, b));
    }
    public static List<Integer> common(int[] a, int[] b){

        List<Integer> result = new ArrayList<>();
        //if

        int a1 = 0; int b1 =0;
        while(a1 < a.length && b1 < b.length){
            //Same
            if(a[a1] == b[b1]){
                if(!result.contains(a[a1]))
                    result.add(a[a1]);
                a1++;
                b1++;

            }else if (a[a1] < b[b1] ){
                a1++;
            }else{
                b1++;
            }
        }
        return result;

    }
}



//
//Listerners FIX -> Covert fix to Object -> Publish -> UI ( Upating values in the row)
//        KAfka Listerner -> Convert to our required -> Store file at a location.class
//
//
//
//    System -> cron job -> Proces files -> find diff -> create excel and email.
//A -> Servie1 -> Pricer -> service 2 -> Publish UI
//
//
//enum Price{
//    KAFKA(true, false),
//    FIX(false, true),
//    DUAL(true, true)
//}
//

//Function to merge int arrays so that only common elements appear.

//


//PriceValue --> Rule Engine
//        if(ifFIXEnabled()){
//        Do the stuff //Unique Id (new row creation)
//        }
//        if(isKAFKAenabled()){
//        Do the stuff //Unique Id
//        }
//Publish -> 3 diffrent -> Sub to new row