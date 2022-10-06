import org.junit.Test;

public class lc122BestTimeToSellAndBuyStock2 {
    // 每个点的状态（最大profit）等于新加当前点在前面每个点作为买点 再加上买点前面的状态的最大值
//    public int maxProfit(int[] prices) {
//        int[] cache = new int[prices.length + 1];
//        int ret = 0;
//        for (int i = 1; i < prices.length; i++) {
//            int curProfit = 0;
//            for (int j = i - 1; j >= 0; j--) {
//                if (prices[i] > prices[j]) {
//                    curProfit = Math.max(curProfit, prices[i] - prices[j] + cache[j]);
//                }
//            }
//            ret = Math.max(ret, curProfit);
//            cache[i + 1] = ret;
//        }
//        return ret;
//    }

    public int maxProfit(int[] A) {
        int n = A.length, lastBuy = -A[0], lastSold = 0;
        if (n == 0) return 0;

        for (int i = 1; i < n; i++) {
            //现在买入了股票最大的钱
            int curBuy = Math.max(lastBuy, lastSold - A[i]);
            //现在卖出了股票最大的钱
            int curSold = Math.max(lastSold, lastBuy + A[i]);
            lastBuy = curBuy;
            lastSold = curSold;
        }

        return lastSold;
    }

    @Test
    public void test() {
        System.out.println(maxProfit(new int[]{3, 2, 6, 5, 0, 3}));
        System.out.println();
    }
}
