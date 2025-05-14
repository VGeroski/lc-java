package array;

/**
 * Problem (383)
 * Given two strings ransomNote and magazine,
 * return true if ransomNote can be constructed by using the letters from magazine
 * and false otherwise.
 * <p>
 * Each letter in magazine can only be used once in ransomNote.
 */
public class RansomNote {

    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] freqArray = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            freqArray[magazine.charAt(i) - 'a']++;
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            freqArray[c - 'a']--;

            // as soon as there is no enough letters to construct ransomNote
            // return false
            if (freqArray[c - 'a'] < 0) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(canConstruct("a", "b"));
        System.out.println(canConstruct("aa", "ab"));
        System.out.println(canConstruct("aa", "aab"));
    }
}
