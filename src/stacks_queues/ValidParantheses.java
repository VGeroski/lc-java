package stacks_queues;

import java.util.HashMap;
import java.util.Stack;

/**
 * Problem (20)
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', 
 * determine if the input string is valid.
 * 
 * An input string is valid if:
 * 
 * - Open brackets must be closed by the same type of brackets.
 * - Open brackets must be closed in the correct order.
 * - Every close bracket has a corresponding open bracket of the same type.
 */
public class ValidParantheses {
    
    public static boolean isValid(String s) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            
            // for closing parantheses, check if it is valid pair
            if (map.containsKey(current)) {
                if (stack.isEmpty()) return false;
                
                char pop = stack.pop();
                if (pop != map.get(current))
                    return false;

            // if we hit open parantheses put on stack
            } else {
                stack.push(current);
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println("Valid - ()[]{} ? " + (isValid("()[]{}") ? "yes" : "no"));
        System.out.println("Valid - () ? " + (isValid("()") ? "yes" : "no"));
        System.out.println("Valid - (] ? " + (isValid("(]") ? "yes" : "no"));
        System.out.println("Valid - ([]) ? " + (isValid("([])") ? "yes" : "no"));
    }
}
