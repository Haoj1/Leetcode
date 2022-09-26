public class ListNode {
  int val;
  ListNode next;

  ListNode() {
  }

  ListNode(int val) {
    this.val = val;
  }

  ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }

  public static void printList(ListNode head) {
    ListNode node = head;
    while (node != null) {
      System.out.print(node.val + ", ");
      node = node.next;
    }
    System.out.println();
  }
}
