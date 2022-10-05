public class SearchMatrix {
  int mid;
  public boolean searchRow(int[] row, int target, int begin, int end) {
    if (begin > end) {
      return false;
    }
    if (begin == end) {
      return row[begin] == target;
    }
    mid = (begin + end) / 2;
    if (row[mid] == target) {
      return true;
    }
    return target <= row[mid] ? searchRow(row, target, begin, mid) : searchRow(row, target, mid+1,end);
  }
  public boolean searchCol(int[][] matrix, int target, int begin, int end) {
    if (begin > end) {
      return false;
    }
    if (begin == end) {
      return searchRow(matrix[begin], target, 0, matrix[begin].length);
    }
    mid = (begin + end) / 2;
    return target <= matrix[mid][matrix[0].length-1] ?
        searchCol(matrix, target, begin, mid) : searchCol(matrix, target, mid+1, end);
  }
  public boolean searchMatrix(int[][] matrix, int target) {

    return searchCol(matrix, target, 0, matrix.length);
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    SearchMatrix sol = new SearchMatrix();
    int[] a = new int[]{1,3,4,6,7};

    System.out.println(sol.searchRow(a,-10,0,a.length-1));
  }
}
