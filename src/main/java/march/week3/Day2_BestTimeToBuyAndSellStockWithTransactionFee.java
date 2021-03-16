package march.week3;

public class Day2_BestTimeToBuyAndSellStockWithTransactionFee {
    public int maxProfit(int[] prices, int fee) {
        int stock = Integer.MIN_VALUE;
        int cash = 0;
        for(int price : prices) {
            stock = Math.max(stock, cash - price);
            cash = Math.max(cash, stock + price - fee);
        }
        return cash;
    }
}
