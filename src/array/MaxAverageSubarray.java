package array;

/**
 * Problem (643)
 * You are given an integer array nums consisting of n elements, and an integer k.
 * 
 * Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value.
 * Any answer with a calculation error less than 10-5 will be accepted.
 */
public class MaxAverageSubarray {
    
    public static double findMaxAverage(int[] nums, int k) {
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;

        // calculate current sum
        for (int i = 0; i < k; i++) {
            currSum += nums[i];
        }

        // initialize max sum to be sum of first k numbers
        maxSum = currSum;

        for (int i = k; i < nums.length; i++) {
            // update sum
            currSum += (nums[i] - nums[i - k]);

            // update max sum if needed
            if (currSum > maxSum) maxSum = currSum;
        }

        return (double) maxSum / k;
    }

    public static void main(String[] args) {
        int[] example1 = {1, 12, -5, -6, 50, 3};
        int k = 4;

        System.out.println("Maximum average is: " + findMaxAverage(example1, k));

        int[] example2 = {5};
        k = 1;
        System.out.println("Maximum average is: " + findMaxAverage(example2, k));
    }
}
