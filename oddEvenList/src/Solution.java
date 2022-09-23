class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
   }
public class Solution {
  
  public ListNode oddEvenList(ListNode head) {
    ListNode oddTail = head;
    if (head == null) {
      return null;
    }
    int index = 2;
    ListNode evenHead = head.next;
    ListNode evennode = evenHead;
    ListNode node = head.next;
    while (node != null) {
      if (index % 2 == 0 && node.next != null) {
        oddTail.next = node.next;
        oddTail = oddTail.next;
      } else if (index % 2 != 0 && node.next != null) {
        evennode.next = node.next;
        evennode = evennode.next;
      }
      node = node.next;
      index++;
    }
    if (evennode != null) {
      evennode.next = null;
    }
   
    oddTail.next = evenHead;
    return head;
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
