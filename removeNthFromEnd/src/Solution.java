import java.util.ArrayList;

class ListNode {
  int val;
  ListNode next;
  ListNode() {}
  ListNode(int val) { this.val = val; }
  ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
public class Solution {
  
  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode node = head;
    ArrayList<ListNode> list = new ArrayList<ListNode>();
    while (node != null) {
      list.add(node);
      node = node.next;
    }
    if (list.size() == 1) {
      head = null;
    }
    else if (n == 1) {
      list.get(list.size()-n-1).next = null;
    }
    else {
      list.get(list.size()-n-1).next = list.get(list.size()-n+1);
    }
    return head;
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
