import org.junit.Test;

// amount递增，每个amount的最少coins情况等于 含有每个（小于等于这个amount）coin的这种情况的最小
import java.util.Arrays;

public class lc322CoinChange {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        Arrays.sort(coins);
        int[] cache = new int[amount + 1];
        for (int i = 1; i < amount + 1; i++) {
            int currentComb = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length && coins[j] <= i; j++) {
                int offset = i - coins[j];
                if (offset == 0) {
                    currentComb = 1;
                } else if (cache[offset] > 0) {
                    currentComb = Math.min(currentComb, cache[offset] + 1);
                }
            }
            if (currentComb != Integer.MAX_VALUE) {
                cache[i] = currentComb;
            }
        }
        return cache[amount] > 0 ? cache[amount] : -1;
    }

    @Test
    public void test() {
        System.out.println(coinChange(new int[]{1, 2, 5}, 11));
        System.out.println();
    }
}
