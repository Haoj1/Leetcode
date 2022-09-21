package spiralOrder;

import java.util.*;

public class Solution {
  public List<Integer> travelLoop(int[][] matrix, int loop) {
    LinkedList<Integer> list = new LinkedList<Integer>();
    for (int i = loop; i < matrix[0].length - loop; i++) {
      list.add(matrix[loop][i]);
//      System.out.print(matrix[loop][i]+"\n");
    }

      for (int i = loop+1; i < matrix.length - loop; i++) {
        list.add(matrix[i][matrix[0].length - loop -1]);
//        System.out.print(matrix[i][matrix[0].length - loop -1]+"\n");
      }
    
    if (matrix.length-2*loop>1) {
      for (int i = matrix[0].length-loop-2; i >= loop; i--) {
        list.add(matrix[matrix.length - loop -1][i]);
//        System.out.print("10\n");
      }
    }
    
    if (matrix[0].length-2*loop>1) {
      for (int i = matrix.length-loop-2; i >= loop+1; i--) {
        list.add(matrix[i][loop]);
//        System.out.print("10\n");
      }
    }
    
    return list;
  }
  public List<Integer> spiralOrder(int[][] matrix) {
    LinkedList<Integer> list = new LinkedList<Integer>();
    int loop = 0;
    int m = matrix.length;
    int n = matrix[0].length;
    while (2*loop<=m && 2*loop<=n) {
      list.addAll(travelLoop(matrix, loop));
      loop++;
//      System.out.print("10\n");
    }
    return list;
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Solution sol = new Solution();
//  int[] a1 = {1,2,3};
//  int[] a2 = {4,5,6};
  int[][] a3 = {{1,2,3}, {4,5,6}, {7,8,9}, {1,2,3}, {4,5,6}, {7,8,9}};
  int[][] a4 = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16}};
//  int[] temp = sol.move(a1, a2);
//  System.out.println(Arrays.toString(a1));
//  System.out.println(Arrays.toString(a2));
//  sol.rotate(a4);
//  for (int i = 0; i < a3.length; i++) {
//    System.out.println(Arrays.toString(a3[i]));
//  }
  List<Integer> list = sol.spiralOrder(a3);
  for (int i = 0; i < list.size(); i++) {
    System.out.print(list.get(i) + " ");
  }
}
}


