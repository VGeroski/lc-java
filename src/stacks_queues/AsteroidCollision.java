package stacks_queues;

import java.util.Stack;

/**
 * Problem (735)
 * We are given an array asteroids of integers representing asteroids in a row. 
 * The indices of the asteriod in the array represent their relative position in space.
 * 
 * For each asteroid, the absolute value represents its size, 
 * and the sign represents its direction (positive meaning right, negative meaning left). 
 * Each asteroid moves at the same speed.
 * 
 * Find out the state of the asteroids after all collisions.
 * If two asteroids meet, the smaller one will explode. 
 * If both are the same size, both will explode. 
 * Two asteroids moving in the same direction will never meet.
 */
public class AsteroidCollision {
    
    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();

        for (int asteriod : asteroids) {
            if (asteriod > 0) st.push(asteriod);
            else {
                while (!st.isEmpty() && st.peek() > 0 && Math.abs(asteriod) > st.peek())
                    st.pop();
                
                if (st.isEmpty() || st.peek() < 0) st.push(asteriod);
                else if (st.peek() + asteriod == 0) st.pop();
            }
        }

        int[] ans = new int[st.size()];
        for (int i = ans.length - 1; i >= 0; i--) ans[i] = st.pop();

        return ans;
    }

    public static void main(String[] args) {
        int[] asteroids = {5, 10, -5};
        int[] res = asteroidCollision(asteroids);

        System.out.print("After collision: ");
        for (int r : res) System.out.print(r + " ");
        System.out.println();

        int[] asteroids2 = {8, -8};
        int[] res2 = asteroidCollision(asteroids2);

        System.out.print("After collision: ");
        for (int r : res2) System.out.print(r + " ");
        System.out.println();

        int[] asteroids3 = {10, 2, -5};
        int[] res3 = asteroidCollision(asteroids3);

        System.out.print("After collision: ");
        for (int r : res3) System.out.print(r + " ");
        System.out.println();

    }
}
