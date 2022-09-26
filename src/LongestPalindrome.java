import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {
  public int longestPalindrome(String[] words) {
    int res = 0;
    HashMap<String, Integer> hashmap = new HashMap<>();
    String reverse = "";

    for (int i = 0; i < words.length; i++) {

      if (!hashmap.containsKey(words[i])) {
        hashmap.put(words[i], 1);
      } else {
        hashmap.put(words[i], hashmap.get(words[i]) + 1);
      }
    }
    System.out.println(hashmap.toString());
    boolean center = false;
    for (Map.Entry <String, Integer> entry : hashmap.entrySet()) {
      reverse = "";
      reverse += entry.getKey().charAt(1);
      reverse += entry.getKey().charAt(0);
      if (entry.getKey().equals(reverse)) {
        if (center) {
          res += entry.getValue()/2*4;
        }
        else {
          if (entry.getValue() % 2 == 1) {
            res+=2;
            center = true;
          }
          res += entry.getValue() / 2 *4;
        }
        continue;
      }
      if (hashmap.containsKey(reverse)) {
        res += Math.min(entry.getValue(), hashmap.get(reverse))*2;

      }
    }
    return res;
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    String[] words = {"cc","ll","xx"};
    LongestPalindrome sol = new LongestPalindrome();

    System.out.println(sol.longestPalindrome(words));
  }
}
