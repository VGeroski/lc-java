package array;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem (1431)
 * There are n kids with candies. You are given an integer array candies,
 * where each candies[i] represents the number of candies the ith kid has, and an integer extraCandies, 
 * denoting the number of extra candies that you have.
 * 
 * Return a boolean array result of length n, where result[i] is true if, 
 * after giving the ith kid all the extraCandies,
 * they will have the greatest number of candies among all the kids, or false otherwise.
 * Note that multiple kids can have the greatest number of candies.
 */
public class KidsWithGreatesNumberOfCandies {

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<>(candies.length);

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < candies.length; i++) {
            if (candies[i] > max) max = candies[i];
        }

        for (int i = 0; i < candies.length; i++) {
            result.add((candies[i] + extraCandies) >= max);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] candies = {2, 3, 5, 1, 3};
        int extraCandies = 3;
        List<Boolean> res = kidsWithCandies(candies, extraCandies);
        res.stream().forEach(i -> System.out.print(i  + " "));
        System.out.println();

        int[] candies2 = {4, 2, 1, 1, 2};
        extraCandies = 1;
        res = kidsWithCandies(candies2, extraCandies);
        res.stream().forEach(i -> System.out.print(i  + " "));
        System.out.println();

        int[] candies3 = {12, 1, 12};
        extraCandies = 10;
        res = kidsWithCandies(candies3, extraCandies);
        res.stream().forEach(i -> System.out.print(i  + " "));
        System.out.println();
    }
}
