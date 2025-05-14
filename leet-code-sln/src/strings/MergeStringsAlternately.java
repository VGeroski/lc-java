package strings;

/**
 * Problem (1768)
 * You are given two strings word1 and word2. 
 * Merge the strings by adding letters in alternating order, starting with word1.
 * 
 * If a string is longer than the other, append the additional letters onto the end of the merged string.
 * Return the merged string.
 */
public class MergeStringsAlternately {
    public static String mergeAlternately(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();

        StringBuilder sb = new StringBuilder();

        if (n1 == n2) {
            for (int i = 0; i < n1; i++) {
                sb.append(word1.charAt(i));
                sb.append(word2.charAt(i));
            }
        
        } else if (n1 > n2) {
            int i;
            for (i = 0; i < n2; i++) {
                sb.append(word1.charAt(i));
                sb.append(word2.charAt(i));
            }
            sb.append(word1.substring(i, n1));

        } else {
            int i;
            for (i = 0; i < n1; i++) {
                sb.append(word1.charAt(i));
                sb.append(word2.charAt(i));
            }
            sb.append(word2.substring(i, n2));
        }

        return sb.toString();
    }

    public static String mergeAlternatelyV2(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();

        StringBuilder sb = new StringBuilder();

        // if same length - no need to waste time on index checking
        if (n1 == n2) {
            for (int i = 0; i < n1; i++) {
                sb.append(word1.charAt(i));
                sb.append(word2.charAt(i));
            }
            return sb.toString();
        }

        for (int i = 0; i < n1 || i < n2; i++) {
            if (i < n1) sb.append(word1.charAt(i));
            if (i < n2) sb.append(word2.charAt(i));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("Merged string: " + mergeAlternately("abc", "pqr"));
        System.out.println("Merged string: " + mergeAlternately("ab", "pqrs"));
        System.out.println("Merged string: " + mergeAlternately("abcd", "pq"));
    }
}
