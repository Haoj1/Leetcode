import java.util.HashMap;

public class IsBalanced {
  public void height(TreeNode root, HashMap<TreeNode, Integer> map) {
    if (root.left == null && root.right == null) {
      map.put(root, 1);
      return;
    }
    height(root.left, map);
    height(root.right, map);
    map.put(root, Math.max(map.get(root.left), map.get(root.right))+1);
  }
  public boolean isBalanced(TreeNode root, HashMap<TreeNode, Integer> map) {
    if (root == null || (root.left == null && root.right == null)) {
      return true;
    }
//    boolean res = true;
//    if (root.left == null) {
//      return isBalanced(root.right, map) && map.get(root.right) <= 1;
//    }
//    if (root.right == null) {
//      return isBalanced(root.left, map) && map.get(root.left) <= 1;
//    }
    return isBalanced(root.left, map) && isBalanced(root.right, map) &&
            Math.abs(map.get(root.right) - map.get(root.left)) <= 1;
  }
  public boolean isBalanced(TreeNode root) {
    HashMap<TreeNode, Integer> tree = new HashMap<>();
    tree.put(null, 0);
    height(root, tree);
    return isBalanced(root, tree);
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub


    System.out.println();
  }
}
