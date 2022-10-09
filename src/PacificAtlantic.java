import java.util.*;

public class PacificAtlantic {

  public List< List<Integer>> pacificAtlantic(int[][] heights) {
    int rows = heights.length;
    int cols = heights[0].length;
    boolean[][] pac = new boolean[rows][cols];
    boolean[][] atl = new boolean[rows][cols];
    Queue<int[]> q_pac = new LinkedList<>();
    Queue<int[]> q_atl = new LinkedList<>();
    for (int i = 0; i < rows; i++) {
      pac[i][0] = true;
      atl[i][cols-1] = true;
      q_pac.add(new int[]{i,0});
      q_atl.add(new int[]{i,cols-1});
    }
    for (int i = 0; i < cols; i++) {
      pac[0][i] = true;
      atl[rows-1][i] = true;
      q_pac.add(new int[]{0,i});
      q_atl.add(new int[]{rows-1,i});
    }
    while (!q_pac.isEmpty()){
      int[] temp = q_pac.poll();
      findPath(temp[0]+1, temp[1], rows, cols, heights,pac, q_pac, heights[temp[0]][temp[1]]);
      findPath(temp[0]-1, temp[1], rows, cols, heights,pac, q_pac, heights[temp[0]][temp[1]]);
      findPath(temp[0], temp[1]-1, rows, cols, heights,pac, q_pac, heights[temp[0]][temp[1]]);
      findPath(temp[0], temp[1]+1, rows, cols, heights,pac, q_pac, heights[temp[0]][temp[1]]);
    }
    while (!q_atl.isEmpty()){
      int[] temp = q_atl.poll();
      findPath(temp[0]-1, temp[1], rows, cols, heights,atl, q_atl, heights[temp[0]][temp[1]]);
      findPath(temp[0]+1, temp[1], rows, cols, heights,atl, q_atl, heights[temp[0]][temp[1]]);
      findPath(temp[0], temp[1]-1, rows, cols, heights,atl, q_atl, heights[temp[0]][temp[1]]);
      findPath(temp[0], temp[1]+1, rows, cols, heights,atl, q_atl, heights[temp[0]][temp[1]]);
    }
    List< List<Integer>> res = new ArrayList<List<Integer>>();
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (pac[i][j] && atl[i][j]) {
          res.add(Arrays.asList(i,j));
        }
      }
    }
    return res;
  }
  public void findPath(int row, int col, int rows, int cols, int[][] heights, boolean[][] map,
                       Queue<int[]> q, int preHeight) {
    if (row < 0 || row >= rows || col < 0 || col >= cols || preHeight > heights[row][col] || map[row][col]) {
      return;
    }
    map[row][col] = true;
    q.add(new int[]{row, col});
  }
}
