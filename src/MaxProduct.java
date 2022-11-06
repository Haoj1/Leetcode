import java.util.Arrays;

public class MaxProduct {
  public int maxProduct(int[] nums) {
    int[][] dp = new int[nums.length][2];
    dp[0][0] = nums[0];
    dp[0][1] = nums[0];
    int end = 0;
    int start = 0;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i-1] == 0) {
        dp[i][0] = nums[i];
        dp[i][1] = nums[i];
        start = -1;
        end = -1;
      }
      if (nums[i] < 0 ) {
        end = i;
        if (start == -1) {
          start = i;
        }
      }
      if (nums[i-1] != 0) {
        dp[i][0] = dp[i-1][0] * nums[i];
        if (dp[i][0] < 0) {
          dp[i][1] = Math.max(dp[i][0]/dp[start][0],dp[end][0]/nums[end]);
        } else {
          dp[i][1] = dp[i][0];
        }
      }
      System.out.println(dp[i][1]);
    }
    int max = -100;
    for (int i = 0; i < dp.length; i++) {
      if (dp[i][1] > max) {
        max = dp[i][0];
      }
    }
    return max;
  }
}
