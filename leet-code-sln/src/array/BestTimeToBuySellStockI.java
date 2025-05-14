package array;

/**
 * Problem (121)
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * <p>
 * You want to maximize your profit by choosing a single day to buy one stock and choosing
 * a different day in the future to sell that stock.
 * <p>
 * Return the maximum profit you can achieve from this transaction.
 * If you cannot achieve any profit, return 0.
 */
public class BestTimeToBuySellStockI {

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        int profit = 0;
        int left = 0;

        for (int right = 1; right < prices.length; right++) {

            if (prices[right] > prices[left]) {

                // update profit if hit better selling time
                profit = Math.max(profit, prices[right] - prices[left]);

            } else {
                // we found that smaller buying price, so shift left pointer
                left = right;
            }
        }
        return profit;
    }

    public static void main(String[] args) {

        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));

        int[] prices2 = {7, 6, 4, 3, 1};
        System.out.println(maxProfit(prices2));
    }

}
