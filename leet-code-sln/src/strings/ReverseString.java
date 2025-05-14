package strings;

/**
 * Problem (344)
 * Write a function that reverses a string. The input string is given as an array of characters s.
 * You must do this by modifying the input array in-place with O(1) extra memory.
 */
public class ReverseString {
    
    public static void reverseString(char[] s) {
        if (s.length == 0) return;

        int left = 0;
        int right = s.length - 1;

        while (left < right) {
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        char[] example1 = {'h','e','l','l','o'};
        char[] example2 = {'H','a','n','n','a', 'h'};

        reverseString(example1);
        reverseString(example2);

        System.out.println("Reversed string:");
        for (char c : example1) System.out.print(c + " ");
        System.out.println();
        for (char c : example2) System.out.print(c + " ");
        System.out.println();
    }
}
