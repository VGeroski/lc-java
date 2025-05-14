package array;

import java.util.HashMap;

/**
 * Problem (1)
 * Given an array of integers nums and an integer target, 
 * return indices of the two numbers such that they add up to target.
 * 
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 */
public class TwoSum {
    
    public static int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];

            // if we found diff key in map, we have both indexes: i and map.get(diff)
            if (map.containsKey(diff)) {
                res[0] = i;
                res[1] = map.get(diff);
                break;
            
            // if there is no diff key in map keep adding elements from array into map
            } else {
                map.put(nums[i], i);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] result = twoSum(nums, target);
        System.out.println("indexes for given target: " + result[0] + ", " + result[1]);

        int[] nums2 = {3, 2, 4};
        target = 6;
        result = twoSum(nums2, target);
        System.out.println("indexes for given target: " + result[0] + ", " + result[1]);

        int[] nums3 = {3, 3};
        result = twoSum(nums3, target);
        System.out.println("indexes for given target: " + result[0] + ", " + result[1]);
    }
}
