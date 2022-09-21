import java.util.*;

public class Solution {
 
  public void swap(int[][] matrix, int times) {
    int[] temp = new int[matrix.length-times-1];
    for (int i = times; i < matrix.length-times-1; i++) {
      temp[i] = matrix[i][matrix.length-times-1];
      matrix[i][matrix.length-times-1] = matrix[times][i];
      matrix[times][i] = temp[i];
    }
    for (int i = times; i < matrix.length-times-1; i++) {
      temp[i] = matrix[matrix.length-times-1][matrix.length-1-i];
      matrix[matrix.length-times-1][matrix.length-1-i] = matrix[times][i];
      matrix[times][i] = temp[i];
    }
    for (int i = times; i < matrix.length-times-1; i++) {
      temp[i] = matrix[matrix.length-1-i][times];
      matrix[matrix.length-1-i][times] = matrix[times][i];
      matrix[times][i] = temp[i];
    }
//    for (int i = 0; i < matrix.length-1; i++) {
//      temp[i] = matrix[matrix.length-1-i][0];
//      matrix[matrix.length-1-i][0] = matrix[0][i];
//      matrix[0][i] = temp[i];
//    }
    temp = null;
  }
  
  public void rotate(int[][] matrix) {
    for (int i = 0; i * 2 <= matrix.length; i++ ) {
      swap(matrix, i);
    }
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Solution sol = new Solution();
//    int[] a1 = {1,2,3};
//    int[] a2 = {4,5,6};
    int[][] a3 = {{1,2,3}, {4,5,6}, {7,8,9}};
    int[][] a4 = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16}};
//    int[] temp = sol.move(a1, a2);
//    System.out.println(Arrays.toString(a1));
//    System.out.println(Arrays.toString(a2));
//    sol.rotate(a4);
//    for (int i = 0; i < a3.length; i++) {
//      System.out.println(Arrays.toString(a3[i]));
//    }
    sol.rotate(a4);
    for (int i = 0; i < a4.length; i++) {
      System.out.println(Arrays.toString(a4[i]));
    }
  }

}
