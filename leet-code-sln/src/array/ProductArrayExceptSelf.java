package array;

/**
 * Problem (238)
 * Given an integer array nums, return an array answer such that 
 * answer[i] is equal to the product of all the elements of nums except nums[i].
 * 
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 */
public class ProductArrayExceptSelf {
    
    public static int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];

        // construct prefix product
        result[0] = 1; // base case for first element
        for (int i = 1; i < nums.length; i++)
            result[i] = result[i - 1] * nums[i - 1];

        // construct suffix product
        // we don't need array, variable is enough
        int suffixProduct = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] = result[i] * suffixProduct;
            suffixProduct = suffixProduct * nums[i];
        }

        return result;
    }

    public static void printArray(int[] array) {
        System.out.println("Product: ");
        for (int j : array) System.out.print(" " + j);

        System.out.println();
    }

    public static void main(String[] args) {
        int[] example = {1, 2, 3, 4};
        int[] productExceptSelf = productExceptSelf(example);
        printArray(productExceptSelf);

        int[] example2 = {-1, 1, 0, -3, 3};
        productExceptSelf = productExceptSelf(example2);
        printArray(productExceptSelf);
    }
}
