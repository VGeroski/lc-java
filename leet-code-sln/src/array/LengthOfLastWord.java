package array;

/**
 * Problem (58)
 * Given a string s consisting of words and spaces, return the length of the last word in the string.
 * A word is a maximal consisting of non-space characters only.
 */
public class LengthOfLastWord {

    public static int lengthOfLastWord(String s) {
        int right = s.length() - 1;
        // ' some word the  '
        //               r (right pointer)
        //            l (left pointer)
        while (right >= 0 && s.charAt(right) == ' ') right--;

        int left = right;
        while (left >=0 && s.charAt(left) != ' ') left--;

        return right - left;
    }

    public static void main(String[] args) {

        System.out.println(lengthOfLastWord("Hello World"));
        System.out.println(lengthOfLastWord("   fly me   to   the moon  "));
        System.out.println(lengthOfLastWord("luffy is still joyboy"));
    }
}
