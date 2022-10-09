import java.util.Stack;

public class BSTIterator {
  Stack<TreeNode> stack;
  public BSTIterator(TreeNode root) {
    stack =  new Stack<>();
    init(root);
//    stack.push(new TreeNode(-1));
  }
  public void init(TreeNode root) {
    if (root == null) {
      return;
    }
    init(root.right);
    stack.push(root);
    init(root.left);
  }
  public int next() {
    return stack.pop().val;
  }

  public boolean hasNext() {
    return stack.size() > 0;
  }
}
