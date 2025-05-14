package array;

/**
 * Problem (283)
 * Given an integer array nums, move all 0's to the end of it while maintaining 
 * the relative order of the non-zero elements.
 * 
 * Note that you must do this in-place without making a copy of the array.
 */
public class MoveZeros {

    public static void moveZeroes(int[] nums) {
        if (nums.length == 1) return;

        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            // if right pointer is non-zero element
            // swap values from right to left position
            if (nums[right] != 0) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++; // shift left pointer after swap
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes(nums);
        System.out.println("After moving zeros: ");
        for (int num : nums) System.out.print(num + " ");
        System.out.println();
    }
}
