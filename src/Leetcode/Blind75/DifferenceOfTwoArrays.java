package Leetcode.Blind75;

import java.util.*;
import java.util.stream.Collectors;

public class DifferenceOfTwoArrays {
    public static void main(String[] args) {
        DifferenceOfTwoArrays differenceOfTwoArrays = new DifferenceOfTwoArrays();
        differenceOfTwoArrays.findDifference(new int[]{1,2,3}, new int[]{2,4,6}).forEach(System.out::println);
    }
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> result = new ArrayList<>();
        Set<Integer> numsSet1 = new HashSet<>();
        Set<Integer> numsSet2 = new HashSet<>();

        for(Integer nums : nums1){
            numsSet1.add(nums);
        }

        for(Integer nums : nums2){
            numsSet2.add(nums);
        }

        Set<Integer> diff1 = new HashSet<>(numsSet1);
        Set<Integer> diff2 = new HashSet<>(numsSet2);
        diff1.removeAll(numsSet2);

        diff2.removeAll(numsSet1);


        result.add(new ArrayList<>(diff1));
        result.add(new ArrayList<>(diff2));

        return result;
    }
}


//public class FindDifferenceOfTwoArrays {
//    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
//        // Convert arrays to sets
//        Set<Integer> set1 = new HashSet<>();
//        Set<Integer> set2 = new HashSet<>();
//        for (int num : nums1) set1.add(num);
//        for (int num : nums2) set2.add(num);
//
//        // Find elements in nums1 but not in nums2
//        Set<Integer> diff1 = new HashSet<>(set1);
//        diff1.removeAll(set2);
//
//        // Find elements in nums2 but not in nums1
//        Set<Integer> diff2 = new HashSet<>(set2);
//        diff2.removeAll(set1);
//
//        // Convert sets to lists
//        List<Integer> list1 = new ArrayList<>(diff1);
//        List<Integer> list2 = new ArrayList<>(diff2);
//
//        // Return the result as a list of two lists
//        List<List<Integer>> result = new ArrayList<>();
//        result.add(list1);
//        result.add(list2);
//        return result;
//    }
//
//}
