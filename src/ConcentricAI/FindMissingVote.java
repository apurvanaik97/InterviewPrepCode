package ConcentricAI;

import java.util.*;

public class FindMissingVote {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        Scanner sc = new Scanner(System.in);
        System.out.println("Input number of test cases");

        int testCases = sc.nextInt();

        if(testCases > 0) {
            for (int i = 0; i < testCases; i++) {
                long sumParty1 = 0;
                long sumParty2 = 0;
                int nVotes = sc.nextInt();
//                List<Integer> party1 = new ArrayList<>();
//                for (int j = 0; j < nVotes; j++) {
//                    party1.add(sc.nextInt());
//                }
//                List<Integer> party2 = new ArrayList<>();
//                for (int j = 0; j < party1.size() - 1; j++) {
//                    party2.add(sc.nextInt());
//                }

                for (int j = 0; j < nVotes; j++) {
                    sumParty1 += sc.nextLong();
                }
                for (int j = 0; j < nVotes - 1; j++) {
                    sumParty2 += sc.nextInt();
                }

                System.out.println(sumParty1 - sumParty2);
            }
        }
    }
}

//2
//5
//10 1 1997 6 2000
//1997 1 2000 6
//2
//1 2
//2