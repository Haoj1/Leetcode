import java.util.ArrayList;

public class PathSum {
  public int checkpath(TreeNode root, int targetSum, long preSum) {
    if (root == null) {
      return 0;
    }
    int res = 0;
    if (root.val+preSum == targetSum) {
      res++;
    }
    System.out.println(res);
    return res + checkpath(root.left, targetSum, preSum + root.val) +
        checkpath(root.right, targetSum, preSum + root.val);
  }
  public int pathSum(TreeNode root, int targetSum) {
    if (root == null) {
      return 0;
    }

    return pathSum(root.left, targetSum) + pathSum(root.right, targetSum) + checkpath(root, targetSum, 0);
  }
}
