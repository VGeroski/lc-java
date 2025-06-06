package array;

import java.util.HashSet;
import java.util.Set;

/**
 * Problem (217)
 * Given an integer array nums, return true if any value appears at least twice in the array,
 * and return false if every element is distinct.
 */
public class ContainsDuplicate {

    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) return true;
            set.add(num);
        }

        return false;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 1};
        System.out.println(containsDuplicate(nums));

        int[] nums1 = {1, 2, 3, 4};
        System.out.println(containsDuplicate(nums1));
    }
}
