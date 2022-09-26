import java.util.*;
import java.util.Map;

public class LeastInterval {
  public int leastInterval(char[] tasks, int n) {
    HashMap<Character, Integer> hashmap = new HashMap<>();

    int res = 0;
    int start = 0;
    for (int i = 0; i < tasks.length; i++) {
      if (!hashmap.containsKey(tasks[i])) {
        hashmap.put(tasks[i], 1);
      } else {
        hashmap.put(tasks[i], hashmap.get(tasks[i])+1);
      }

    }
    System.out.println(hashmap);
    System.out.println(hashmap.size());
    int[] list = new int[tasks.length*(n+1)];
    int idle = 0;
    PriorityQueue<Map.Entry<Character, Integer>> q = new PriorityQueue<>((a, b) -> ((int)b.getValue() - (int)a.getValue()));
    for (Map.Entry <Character, Integer> entry : hashmap.entrySet()) {
      q.add(entry);
    }
//    System.out.println(q.poll());
//    System.out.println(q.poll());
    Map.Entry <Character, Integer> entry;
    while ((entry = q.poll()) != null) {
      while (list[idle] != 0) {
        idle++;
      }
      start = idle;

      if (start > res) {
        res = start;
      }

    }

    return res+1;
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    LeastInterval sol = new LeastInterval();
    char[] tasks = {'A','A','A','A','A','A', 'B','B','B','B','B','B','B','B', 'C', 'D', 'E', 'F', 'G'};

    System.out.println(sol.leastInterval(tasks, 2));
  }
}
