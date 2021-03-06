package com.ywh.problem.leetcode.easy;

import com.ywh.problem.leetcode.hard.LeetCode123;
import com.ywh.problem.leetcode.hard.LeetCode188;
import com.ywh.problem.leetcode.medium.LeetCode121;
import com.ywh.problem.leetcode.medium.LeetCode714;

/**
 * 买卖股票的最佳时机 II
 * [数组] [贪心]
 *
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 示例 1：
 *      输入: [7,1,5,3,6,4]
 *      输出: 7
 *      解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *          随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
 * 示例 2：
 *      输入: [1,2,3,4,5]
 *      输出: 4
 *      解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *          注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
 *          因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
 * 示例 3：
 *      输入: [7,6,4,3,1]
 *      输出: 0
 *      解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 * 提示：
 *      1 <= prices.length <= 3 * 10^4
 *      0 <= prices[i] <= 10^4
 *
 * @author ywh
 * @since 04/11/2019
 */
public class LeetCode122 {

    /**
     * Time: O(n), Space: O(1)
     *
     * @param prices
     * @return
     */
    public int maxProfitLocalMaxMin(int[] prices) {
        int profit = 0, buyPrice, sellPrice, i = 0, n = prices.length;
        while (i < n - 1) {
            // 跳过下坡，到波谷后买入
            while (i < n - 1 && prices[i + 1] <= prices[i]) {
                i++;
            }
            buyPrice = prices[i];

            // 跳过上坡，到波峰后卖出
            while (i < n - 1 && prices[i + 1] >= prices[i]) {
                i++;
            }
            sellPrice = prices[i];

            // 记入收益
            profit += (sellPrice - buyPrice);
        }

        return profit;
    }

    /**
     * 参考 {@link LeetCode121}、{@link LeetCode123}、{@link LeetCode188}、{@link LeetCode714}
     *
     * 波峰值 - 波谷值 = 中间两两插值之和
     * 因此只要把所有第二天比第一天价格高的情况计入收益即可（不限买卖次数）
     *
     * 1, 2, 4
     * 4 - 1 = (2 - 1) + (4 - 2)
     *
     * Time: O(n), Space: O(1)
     *
     * @param prices
     * @return
     */
    public int maxProfitGreedy(int[] prices) {
        int ret = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                ret += prices[i] - prices[i - 1];
            }
        }
        return ret;
    }

}
