public class DiameterOfBinaryTree {
  int[] left = new int[2];
  int[] right = new int[2];
  int[] begin = new int[]{-1,-1};
  int dia = 0;
  public int dia_height(TreeNode root) {
    if (root == null) {
      return -1;
    }
//    if ((root.left == null && root.right == null)) {
//      return new int[]{0,0};
//    }
    int left = dia_height(root.left);

    int right = dia_height(root.right);
    int height = Math.max(left, right)+1;
    dia = Math.max(dia, left+right+2);

    return height;
  }
  public int diameterOfBinaryTree(TreeNode root) {
//    if (root.left == null && root.right == null) {
//      return 0;
//    }

    return dia_height(root);
  }
}
