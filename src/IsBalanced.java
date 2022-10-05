import java.util.HashMap;

public class IsBalanced {
  public int height(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int left = height(root.left);
    int right = height(root.right);
    if (left == -1 || right == -1 || Math.abs(left-right) > 1) {
      return -1;
    }
    return Math.max(left, right)+1;
  }

  public boolean isBalanced(TreeNode root) {
    return height(root) >= 0;
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub


    System.out.println();
  }
}
