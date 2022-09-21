
import java.util.LinkedList;

public class Solution {
  public String longestCommonPrefix(String[] strs) {
    String longestStr = "";
    char ch;
    for (int i = 0; ;i++) {
      if (i >= strs[0].length()) {
        return longestStr;
      }
      ch = strs[0].charAt(i);
      for (int j = 0; j < strs.length; j++) {
        if (i >= strs[j].length()) {
          return longestStr;
        }
        if (strs[j].charAt(i) != ch) {
          return longestStr;
          }
      }
      longestStr += ch;
    }
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Solution sol = new Solution();
    int[][] a1 = {{1}};
    String str = "";
    str += 'a';
    str += 'b';
    str += 'h';
    System.out.println(str);
  }

}
