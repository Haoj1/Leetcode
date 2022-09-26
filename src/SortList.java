
public class SortList {
  public ListNode getMid(ListNode head) {
    ListNode slow = head;
    ListNode quick = head;
    while (quick.next != null) {
      quick = quick.next;
      if (quick.next == null) {
        break;
      }
      quick = quick.next;
      slow = slow.next;
    }
    return slow;
  }
  public ListNode merge(ListNode preHead, ListNode postHead) {
    ListNode head;
    if (preHead == null && postHead == null) {
      return null;
    } else if (preHead != null && postHead == null) {
      return preHead;
    } else if (preHead == null && postHead != null) {
      return postHead;
    }
    ListNode node;
    ListNode node1;
    ListNode node2;
    if (preHead.val > postHead.val) {
      head = postHead;
      node1 = preHead;
      node2 = postHead.next;
    } else {
      head = preHead;
      node2 = postHead;
      node1 = preHead.next;
    }
    node = head;
    while (node1 != null && node2 != null) {
      if (node1.val > node2.val) {
        node.next = node2;
        node2 = node2.next;
      }
      else {
        node.next = node1;
        node1 = node1.next;
      }
      node = node.next;
    }
    node.next = (node1 == null? node2 : node1);
    return head;
  }
  public ListNode mergeSort(ListNode head) {
    if (head == null) {
      return null;
    }
    if (head.next == null) {
      return head;
    }
    ListNode mid = getMid(head);
    ListNode postHead = mid.next;
    mid.next = null;
    head = mergeSort(head);
    postHead = mergeSort(postHead);
    head = merge(head, postHead);
    return head;
  }
  public ListNode sortList(ListNode head) {
    ListNode res = mergeSort(head);
    return res;
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    ListNode l1 = new ListNode(20);
    ListNode l2 = new ListNode(4);
    ListNode l3 = new ListNode(9);
    ListNode l4 = new ListNode(2);
    ListNode l5 = new ListNode(7);
    ListNode l6 = new ListNode(8);
    l1.next = l2;
    l2.next = l3;
    l3.next = l4;
    l4.next = l5;
    l5.next = l6;
    SortList sol = new SortList();
    ListNode head = sol.mergeSort(l1);
    ListNode.printList(head);
  }
}
