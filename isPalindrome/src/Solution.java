class ListNode {
  int val;
  ListNode next;
  ListNode() {}
  ListNode(int val) { this.val = val; }
  ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
public class Solution {
  public boolean isPalindrome(ListNode head) {
    ListNode quick = head;
    ListNode slow = head;
    ListNode postHead = null;
    while (quick.next != null) {
      quick  = quick.next;
      if (quick.next == null) {
        break;
      }
      quick  = quick.next;
      slow = slow.next;
    }
    if (quick == head) {
      return true;
    }
//    System.out.print(slow.val + " ");
    ListNode cur = slow.next;
    ListNode pre = null;
    ListNode next = null;
    while (cur != null) {
      if ((next=cur.next) == null) {
        postHead = cur;
        cur.next = pre;
        break;
      }
      cur.next = pre;
      pre = cur;
      cur = next;
    }
//    ListNode node = postHead;
//    while (node != null) {
//      System.out.print(node.val + " ");
//      node = node.next;
//    }
//    System.out.println();
    ListNode n1 = head;
    ListNode n2 = postHead;
    while (n2 != null) {
      if (n2.val != n1.val) {
        return false;
      }
      n1 = n1.next;
      n2 = n2.next;
    }
    return true;
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    ListNode l1 = new ListNode(1);
    ListNode l2 = new ListNode(2);
    ListNode l3 = new ListNode(2);
    ListNode l4 = new ListNode(1);
    l1.next = l2;
    l2.next = l4;
    l3.next = l4;
    Solution sol = new Solution();
    
    System.out.println(sol.isPalindrome(l1));
  }

}
