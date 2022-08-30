
import java.util.*;

public class Solution {
  
  
  public int romanToInt(String s) {
    HashMap<Character, Integer> roman = new HashMap<>();
    int res = 0;
    int counts = 0;
    roman.put('I', 1);
    roman.put('V', 5);
    roman.put('X', 10);
    roman.put('L', 50);
    roman.put('C', 100);
    roman.put('D', 500);
    roman.put('M', 1000);
    for (int i = 0; i < s.length(); i++) {
      counts++;
      if (i+1 < s.length()) {
        if (roman.get(s.charAt(i)) == roman.get(s.charAt(i+1))) {
          
        }
        else if (roman.get(s.charAt(i)) > roman.get(s.charAt(i+1))){
          res += counts * roman.get(s.charAt(i));
          counts = 0;
        }
        else {
          res -= counts * roman.get(s.charAt(i));
          counts = 0;
        }
      }
      else {
        res += counts * roman.get(s.charAt(i));
      }
    }
    return res;

  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub\
    Solution sol = new Solution();
    String s = "MCMXCIV";
    System.out.println(sol.romanToInt(s));
  }

}
