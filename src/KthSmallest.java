public class KthSmallest {
  int val;
  int k;
  int th;
  public void kth(TreeNode root, int k) {
    if(root == null) {
      return;
    }
    kth(root.left, k);
    th++;
    if (th == k) {
      val = root.val;
    }
    else {
      kth(root.right, k);
    }
  }
  public int kthSmallest(TreeNode root, int k) {
    this.k = k;
    this.th = 0;
    kth(root,k);
    return val;
  }
}
