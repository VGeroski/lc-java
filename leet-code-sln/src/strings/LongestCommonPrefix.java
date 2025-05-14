package strings;

/**
 * Problem (14):
 * Write a function to find the longest common prefix string amongst an array of strings.
 * If there is no common prefix, return an empty string "".
 */
public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";

        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                // remove last char
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.length() == 0) return "";
            }
        }

        return prefix;
    }

    public static void main(String[] args) {
        String[] example1 = {"flower", "flow", "flight"};
        String[] example2 = {"dog","racecar","car"};
        String[] example3 = {"leetcode", "lee", "lemon"};

        System.out.println("LCA for example 1: " + longestCommonPrefix(example1));
        System.out.println("LCA for example 2: " + longestCommonPrefix(example2));
        System.out.println("LCA for example 3: " + longestCommonPrefix(example3));
    }
}