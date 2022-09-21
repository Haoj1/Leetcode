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
    ListNode node = slow.next;
    while (node != null) {
      if ()
    }
    return false;
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
