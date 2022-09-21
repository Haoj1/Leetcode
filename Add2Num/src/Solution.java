

 class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Solution {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode result = new ListNode();
    ListNode cur = result;
    int sum = 0;
    while (l1 != null || l2 != null || sum != 0) {
      
      if (l1 != null) {
        sum += l1.val;
        l1 = l1.next;
      }
      if (l2 != null) {
        sum += l2.val;
        l2 = l2.next;
      }
      if (sum >= 10) {
        cur.val = sum - 10;
        sum = 1; 
        cur.next = new ListNode();
      } else {
        cur.val = sum;
        sum = 0;
        if (l1 != null || l2 != null) {
          cur.next = new ListNode();
        }
      }
      cur = cur.next;
    }
    return result;
}
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
