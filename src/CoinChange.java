import java.util.HashMap;
import java.util.Map;

public class CoinChange {
  int[] dp_coins;
  public int coinChange(int[] coins, int amount) {
    dp_coins = new int[amount+1];
    int res = getMinCoins(amount,coins);
    if (res >= 100000) {
      return -1;
    }
    return res;
  }
  public int getMinCoins(int num, int[] coins) {
    System.out.println(num);
    if (num < 0) {
      return 100000;
    }
    if (num == 0) {
      return 0;
    }
    if (dp_coins[num] != 0) {
      return dp_coins[num];
    }
    int min = 100000;
    for (int coin : coins) {
      min = Math.min(min, getMinCoins(num-coin, coins));
    }
    dp_coins[num] = min;
    return min;
  }
}
