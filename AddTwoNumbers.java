// Definition for singly-linked list
class ListNode {
  int val;
  ListNode next;
  ListNode(int x) {
    val = x;
  }
}

public class AddTwoNumbers {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    // Dummy head to simplify result list handling
    ListNode dummyHead = new ListNode(0);
    ListNode current = dummyHead;
    int carry = 0;

    // Traverse both lists
    while (l1 != null || l2 != null || carry != 0) {
      int x = (l1 != null) ? l1.val : 0;
      int y = (l2 != null) ? l2.val : 0;

      int sum = x + y + carry;
      carry = sum / 10; // quotient -> carry
      int digit = sum % 10; // remainder -> digit

      current.next = new ListNode (digit);
      current = current.next;

      if (l1 != null) l1 = l1.next;
      if (l2 != null) l2 = l2.next;
    }

    return dummyHead.next;
  }

  // Helper method to print linked list
  public void printList(ListNode node) {
    while (node != null) {
      System.out.print(node.val);
      if (node.next != null) System.out.print(" -> ");
      node = node.next;
    }
    System.out.println();
  }
  
  public static void main(String[] args) {
    AddTwoNumbers solution = new AddTwoNumbers();

    // First number: 342 -> 2 -> 4 -> 3
    ListNode l1 = new ListNode(2);
    l1.next = new ListNode(4);
    l1.next.next = new ListNode(3);

    // Second number: 465 -> 5 -> 6 -> 4
    ListNode l2 = new ListNode(5);
    l2.next = new ListNode(6);
    l2.next.next = new ListNode(4);

    // Add numbers
    ListNode result = solution.addTwoNumbers(l1, l2);

    // Print result: 807 -> 7 -> 0 -> 8
    solution.printList(result);
  }
}