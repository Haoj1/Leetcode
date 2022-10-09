import java.util.*;

public class OrangesRotting {
  Queue<int[]> q;
  Queue<int[]> q_temp;
  int fresh;
  public void check_fresh(int i, int j, int[][] grid) {
    if (i > 0) {
      if (grid[i-1][j] == 1) {
        grid[i-1][j] = 2;
        fresh--;
        q.add(new int[]{i-1,j});
      }
    }
    if (i < grid.length-1) {

      if (grid[i+1][j] == 1) {
        grid[i-1][j] = 2;
        fresh--;
        q.add(new int[]{i+1,j});
      }
    }
    if (j < grid[0].length-1) {
      if (grid[i][j+1] == 1) {
        grid[i-1][j] = 2;
        fresh--;
        q.add(new int[]{i,j+1});
      }
    }
    if (j > 0) {
      if (grid[i][j-1] == 1) {
        grid[i-1][j] = 2;
        fresh--;
        q.add(new int[]{i,j-1});
      }
    }
  }

  public int orangesRotting(int[][] grid) {
    q = new LinkedList<>();
    q_temp = new LinkedList<>();
    int times = 0;
    fresh = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 2) {
          q.add(new int[]{i,j});
        }
        if (grid[i][j] == 1) {
          fresh++;
        }
      }
    }
    while (!q.isEmpty()) {
      while (!q.isEmpty()) {
        q_temp .add(q.poll());
      }
      while (!q_temp.isEmpty()) {
        int [] temp = q_temp.poll();
        check_fresh(temp[0], temp[1], grid);
      }
      times++;
    }
    if (fresh > 0) {
      return -1;
    }
    return times;
  }
}
