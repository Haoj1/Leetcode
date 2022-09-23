class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
   }
public class Solution {
//  public void swap (ListNode front, ListNode back) {
//    front.next = back.next;
//    back.next = front;
//  }
  public ListNode sortList(ListNode head) {
    if (head == null) {
      return head;
    }
    ListNode end = null;
    ListNode max = null;
    ListNode back;
    ListNode pre;
    while (end != head) {
      max = head;
      pre = null;
      while (max.next != end) {
        if (max.val > max.next.val) {
          if (max == head) {
            head = max.next;
          }
          if (pre == null) {
            
            back = max.next;
            max.next = back.next;
            back.next = max;
            pre = back;
          }  else {
            back = max.next;
            max.next = back.next;
            pre.next = back;
            back.next = max;
            pre = pre.next;
          }         
          
        } else {
          if (pre == null) {
            pre = head;
          } else {
            pre  = max;
          }
          max = max.next;
        }
        
      }
      end = max;
    }
    return head;
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    ListNode l1 = new ListNode(2);
    ListNode l2 = new ListNode(1);
    ListNode l3 = new ListNode(1);
    ListNode l4 = new ListNode(1);
    l1.next = l2;
    l2.next = l3;
    l3.next = l4;
    Solution sol = new Solution();
    
    System.out.println(sol.sortList(l1));
  }

}
