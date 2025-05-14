package stacks_queues;

import java.util.Stack;

/**
 * Problem (394)
 * Given an encoded string, return its decoded string.
 * 
 * The encoding rule is: k[encoded_string],
 * where the encoded_string inside the square brackets is being repeated exactly k times. 
 * Note that k is guaranteed to be a positive integer.
 */
public class DecodeString {
    
    public static String decodeString(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<String> strStack = new Stack<>();

        StringBuilder sb = new StringBuilder();
        int len = s.length();

        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                int num = ch - '0';
                // number can be larger than 9, so we need to collect whole number
                while (i + 1 < len && Character.isDigit(s.charAt(i + 1))) {
                    num = num * 10 + s.charAt(i + 1) - '0';
                    i++;
                }

                numStack.push(num);

            } else if (ch == '[') {
                strStack.push(sb.toString());
                sb = new StringBuilder();

            } else if (ch == ']') {
                int k = numStack.pop();
                StringBuilder tmp = new StringBuilder(strStack.pop());

                // repeat k times
                for (int j = 0; j < k; j++) tmp.append(sb);
                
                sb = tmp;
            
            } else {
                sb.append(ch);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("Decoded 3[a]2[bc]: " + decodeString("3[a]2[bc]"));
        System.out.println("Decoded 3[a2[c]]: " + decodeString("3[a2[c]]"));
        System.out.println("Decoded 2[abc]3[cd]ef: " + decodeString("2[abc]3[cd]ef"));
    }
}
