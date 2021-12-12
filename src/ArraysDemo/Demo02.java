package ArraysDemo;

/**
 * @description:
 * 给定一个数组 prices ，其中prices[i] 是一支给定股票第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 *
 * 输入: prices = [7,1,5,3,6,4]
 * 输出: 7
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 * 随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
 *
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2zsx1/
 * @author: Poison
 * @date: 2021年12月12日 17:16:07
 */
public class Demo02 {
    public static void main(String[] args) {
        int[] prices = new int[]{7,6,4,3,1};
        int i = maxProfit(prices);
        System.out.println(i);
    }
    public static int maxProfit(int[] prices) {
        /*
        首先进行判空
         */
        if(prices==null || prices.length==0){
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < prices.length-1; i++) {
            if(prices[i]<prices[i+1]){
                sum+=prices[i+1]-prices[i];
            }
        }
        return sum;
    }
}

/**
 * 思想：7,1,5,3,6,4
 *观察发现，只需要求出两个元素之间的差值，然后累加即可。
 * 当然，前面的元素要小于后面的元素。
 */

