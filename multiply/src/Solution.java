import java.util.Arrays;

public class Solution {
  public String multiply(String num1, String num2) {
    int n = num1.length();
    int m = num2.length();
    int[] number1 = new int[n];
    int[] number2 = new int[m];
    int[][][] res_table = new int[m+n][m+n][2];
    int[] digits = new int[m+n];
    for (int i = 0; i < n; i++) {
      number1[i] = num1.charAt(n-i-1) - '0';
    }
    
    for (int i = 0; i < m; i++) {
      number2[i] = num2.charAt(m-i-1) - '0';
    }
//    System.out.println(Arrays.toString(number1));
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        res_table[i][j][0] = number1[i] * number2[j] % 10;
        res_table[i][j][1] = number1[i] * number2[j] / 10;
      }
    }
    
    for (int i = 1; i <= digits.length; i++) {
      for (int j = 0 ; j < i; j++) {
        digits[i-1] += res_table[i-j-1][j][0];
        
      }
      for (int j = 0 ; j < i-1; j++) {
        digits[i-1] += res_table[i-j-2][j][1];
        
      }
      if (digits[i-1] >= 10) {
        digits[i] = digits[i-1] / 10;
        digits[i-1] = digits[i-1] % 10;
      }
    }
    
//    for (int i = 0; i < res_table.length; i++) {
//      for (int j = 0; j < res_table[0].length; j++) {
//        System.out.print(Arrays.toString(res_table[i][j]) + " ");
//      }
//      System.out.println();
//    }
    boolean start = false;
    String res = "";
    for (int i = digits.length-1; i >= 0; i--) {
      if (!start && digits[i] != 0) {
        start = true;
      }
      if (start) {
        res += digits[i];
      }
    }
    if (res == "") {
      res = "0";
    }
    System.out.println(res);
    return res;
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Solution sol = new Solution();
    sol.multiply("0", "456");
  }
}
