package strings;

/**
 * Problem (151)
 * Given an input string s, reverse the order of the words.
 * 
 * A word is defined as a sequence of non-space characters. 
 * The words in s will be separated by at least one space.
 * Return a string of the words in reverse order concatenated by a single space.
 * Note that s may contain leading or trailing spaces or multiple spaces between two words.
 * The returned string should only have a single space separating the words.
 * Do not include any extra spaces.
 */
public class ReverseWords {

    public static String reverseWords(String s) {
        // convert String to char array
        // cannot modify String directly
        char[] strArray = s.toCharArray();

        // first step: reverse entire string
        reverse(strArray, 0, strArray.length - 1);

        // second step: reverse each words
        reverseWords(strArray);

        // third step: clean spaces
        return cleanUpSpace(strArray);
    }

    private static String cleanUpSpace(char[] strArray) {
        int left = 0;
        int right = 0;

        // shift right pointer until character
        // update value at position left with value at position right
        // shift left and right by one
        while (right < strArray.length) {
            // find first character
            while (right < strArray.length && strArray[right] == ' ') right++;

            // keep updating left value until we hit empty space again
            while (right < strArray.length && strArray[right] != ' ') {
                strArray[left] = strArray[right];
                left++;
                right++;
            }

            // at this position right is pointing to empty space
            // find again character
            while (right < strArray.length && strArray[right] == ' ') right++;

            // if we are not at the end of string, add space between words
            if (right < strArray.length) {
                strArray[left] = ' ';
                left++;
            }
        }

        // we dont need whole array, just from 0 - left-1
        return new String(strArray).substring(0, left);
    }

    private static void reverseWords(char[] strArray) {
        int left = 0;
        int right = 0;

        // left pointer seeks for alhanumeric, right pointer seeks for empty space
        // when in place, swap places from left to right - 1
        // proceed unitil there is no element to swap
        while (left < strArray.length) {
            // find first non empty space position (find character)
            while (left < strArray.length && strArray[left] == ' ') left++;

            right = left;
            // find first empty space
            while (right < strArray.length && strArray[right] != ' ') right++;

            // reverse word
            reverse(strArray, left, right - 1);

            // after swap, shift left ptr to right
            left = right;
        }
    }

    private static void reverse(char[] strArray, int left, int right) {
        while (left < right) {
            char temp = strArray[left];
            strArray[left] = strArray[right];
            strArray[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        String s = " the  sky is   blue ";
        System.out.println("Reversed: " + reverseWords(s));
    }
}