package strings;

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
        for (int i = 0; i < example1.length; i++) System.out.print(example1[i] + " ");
        System.out.println();
        for (int i = 0; i < example2.length; i++) System.out.print(example2[i] + " ");
        System.out.println();
    }
}
