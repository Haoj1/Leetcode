import java.util.*;
import java.util.Map;

public class LeastInterval {
    public int leastInterval(char[] tasks, int n) {
        int res = 0;
        int[] lists = new int[tasks.length*(n+1)];
        int [][] chars = new int[26][2];
        for (int i = 0 ;i < tasks.length; i++) {
            if (chars[tasks[i]-'A'][0] == 0) {
                chars[tasks[i] - 'A'][1] = -n-1;
            }
            chars[tasks[i]-'A'][0] ++;
        }
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> b[0] - a[0]);
        for (int i = 0; i < 26; i++) {
            if (chars[i][0] != 0){
                q.add(chars[i]);
            }
        }
        for (int[] arr : q) {
            System.out.println("["+arr[0]+ ", " + arr[1] + "]");
        }
        while (!q.isEmpty()) {
            int[] temp = q.poll();
            int index = temp[1];
            index = index + n + 1;
            while (lists[index] != 0) {
                index ++;
            }
            lists[index] = temp[1];
            if (index > res) {
                res = index;
            }
            temp[0]--;
            temp[1] = index;
            if (temp[0] > 0) {
                q.add(temp);
            }
        }
        return res + 1;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        LeastInterval sol = new LeastInterval();
        char[] tasks = {'A', 'A', 'A', 'A', 'A', 'A', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'C', 'D', 'E', 'F', 'G'};

        System.out.println(sol.leastInterval(tasks, 2));
    }
}
