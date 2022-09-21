import java.util.*;
public class Solution {
  
  public int checksum(int n) {
    int sum = 0;
    int residue, digit;
    for (int i = 1; n != 0; i++) {
      residue =  n % (int)Math.pow(10, i);
      digit = residue / (int)Math.pow(10, i-1);
      n = n - residue;
      sum += digit * digit;
    }
    return sum;
  }
  public boolean isHappy(int n) {
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    int sum;
    while(!map.containsKey(n)) {
      sum = checksum(n);
      if (sum == 1) {
        return true;
      }
      map.put(n, sum);
      n = sum;
    }
    return false;
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Solution sol = new Solution();
    System.out.println(sol.isHappy(2));
  }

}
