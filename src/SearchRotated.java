public class SearchRotated {
  int mid;
  public int searchRow(int[] row, int target, int begin, int end) {
    if (begin > end) {
      return -1;
    }
    if (begin == end) {
      return row[begin] == target? begin : -1;
    }
    mid = (begin + end) / 2;
    if (row[mid] == target) {
      return mid;
    }
    return target <= row[mid] ? searchRow(row, target, begin, mid) : searchRow(row, target, mid+1,end);
  }
  public int searchRotatedRow(int[] row, int target, int begin, int end) {
    if (begin > end) {
      return -1;
    }
    if (begin == end) {
      return row[begin] == target? begin : -1;
    }
    mid = (begin + end) / 2;
    if (row[mid] == target) {
      return mid;
    }
    if (target < row[mid] && target >= row[begin]) {
      return searchRow(row, target, begin, mid);
    }
    if (target > row[mid] && target <= row[end]) {
      return searchRow(row, target, mid+1, end);
    }
    if (row[mid] > row[end] && target > row[mid] && target >= row[begin] || (row[mid] < row[end] &&
        target < row[mid] && target <= row[end])) {
      return searchRotatedRow(row, target, begin, mid);
    }
    else {
      return searchRotatedRow(row, target, mid+1, end);
    }
//    return target <= row[mid] ? searchRow(row, target, begin, mid) : searchRow(row, target, mid+1,end);
  }
  public int search(int[] nums, int target) {
    return searchRotatedRow(nums, target, 0, nums.length-1);
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    SearchRotated sol = new SearchRotated();
    int[] a = new int[]{4,5,6,7,0,1,2};

    System.out.println(sol.searchRotatedRow(a,5,0,a.length-1));
  }
}
