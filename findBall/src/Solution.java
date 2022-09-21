import java.util.Arrays;

public class Solution {

//  public void check(int[][] pass) {
//    int row = pass.length;
//    int col = pass[0].length; 
//    for (int i = row )
//  }
  
  public int[] findBall(int[][] grid) {
    int row = grid.length;
    int col = grid[0].length;
    int[][] pass = new int[row+1][col];
    for (int i = 0; i < col; i++) {
      pass[row][i] = i; 
    }
    for (int i = row - 1; i >= 0; i--) {
      for (int j = 0; j < col; j++) {
        if (j == 0 && grid[i][j] == -1) {
          pass[i][j] = -1;
          
        }
        else if (j == col-1 && grid[i][j] == 1) {
          pass[i][j] = -1;
          
        }
        else if (grid[i][j] == 1 && grid[i][j+1] == -1) {
          pass[i][j] = -1;
          
        }
        else if (grid[i][j] == -1 && grid[i][j-1] == 1) {
          pass[i][j] = -1;
          
        }
        else if (grid[i][j] == 1 && grid[i][j+1] == 1 && pass[i+1][j+1] != -1) {
          pass[i][j] = pass[i+1][j+1];
          
        } 
        else if (grid[i][j] == -1 && grid[i][j-1] == -1 && pass[i+1][j-1] != -1) {
          pass[i][j] = pass[i+1][j-1];
          
        } else {
          pass[i][j] = -1;
          
        }
      }
    }
    return pass[0];
  }
  
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Solution sol = new Solution();
    int[][] a1 = {{1}};
    System.out.println(Arrays.toString(sol.findBall(a1)));
  }

}
