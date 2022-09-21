import java.util.*;
public class Solution {
  public boolean greater(int i, int j, int[][] properties) {
    if (properties[i][0] > properties[j][0] && properties[i][1] > properties[j][1]) {
      return true;
    } else {
      return false;
    }
  }
  public void swap (int i, int j, int[][] propertie) {
    int[] temp = new int[2];
    temp[0] = propertie[j][0];
    temp[1] = propertie[j][1];
    propertie[j][0] = propertie[i][0];
    propertie[j][1] = propertie[i][1];
    propertie[i][0] = temp[0];
    propertie[i][1] = temp[1];
  }
  
//  public int sort(int pivot, int[][] properties) {
//    boolean weak = false;
//    int times = 1;
//    int flag = pivot + 1;
//    for (int i = flag; i < properties.length; i++) {
//////      if (i == pivot) {
//////        continue;
//////      }
//      if (greater(pivot, i, properties)) {       
//        num++;
//        swap(flag, i, properties);
//        flag++;
//      } else if (properties[i][0] == properties[pivot][0] && properties[i][1] == properties[pivot][1]) {
//        times++;
//        swap(flag, i, properties);
//        flag++;
//        ////        swap(pivot, i, properties);
//////        pivot = i;
////        weak = true;
////        if (i < pivot) {
////          swap(pivot, i, properties);
////          pivot = i;
////        }
////      } else if (properties[i][0] == properties[pivot][0] && properties[i][1] == properties[pivot][1]) {
////        times++;
////        if (i > pivot) {
////          properties[i][0] -= 1;
////          swap(pivot, i, properties);
////          pivot = i;
////        }
////      } else {
////        if (i < pivot) {
////          swap(pivot, i, properties);
////          pivot = i;
////        }
////        
//      } else if (greater(i, pivot, properties)) {
//        weak = true;
//      }
//    }
//    swap(pivot, flag-1, properties);
//    if (weak) {
//      num += times;
//    }
//    return flag-1;
//  }
  public int numberOfWeakCharacters(int[][] properties) {
    int num = 0;
    int max = 0;
    Arrays.sort(properties, (a, b)->(a[0]==b[0])? a[1]-b[1] : b[0]-a[0]);
    for (int i = 1; i < properties.length; i++) {
      if (properties[max][1]>properties[i][1]) {
        num++;
      }
      else if (properties[max][1] <= properties[i][1]){
        max = i;
      }
    }

    return num;
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Solution sol = new Solution();
    int[][] properties = {{5,5},{2,2},{10,4}, {1,5}, {4,3}, {4,4}, {3,3}};
//    System.out.println(sol.numberOfWeakCharacters(properties));
    Arrays.sort(properties, (a, b)->(a[0]==b[0])? a[1]-b[1] : b[0]-a[0]);
    for (int i = 0; i < properties.length; i++) {
      System.out.println(Arrays.toString(properties[i]));
    }
  }

}
