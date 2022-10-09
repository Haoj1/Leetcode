public class SortedArrayToBST {
  int mid;
  public TreeNode sortedBst(int[] nums, int begin, int end){
    if (begin > end) {
      return null;
    }
    if (begin == end) {
      return new TreeNode(nums[begin]);
    }
    mid = (begin + end)/2;
    TreeNode node = new TreeNode(nums[mid]);
    node.left = sortedBst(nums, begin, mid-1);
    node.right = sortedBst(nums, mid+1, end);
    return node;
  }
  public TreeNode sortedArrayToBST(int[] nums) {

    return sortedBst(nums, 0, nums.length-1);
  }
}
