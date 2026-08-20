public class ReverseLinkedList {

    // Definition of ListNode
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    // Reverse the linked list
    public static ListNode reverseList(ListNode head) {

        ListNode prev = null;
        ListNode current = head;

        while (current != null) {

            // Store the next node
            ListNode next = current.next;

            // Reverse the link
            current.next = prev;

            // Move prev forward
            prev = current;

            // Move current forward
            current = next;
        }

        return prev;
    }

    // Print linked list
    public static void printList(ListNode head) {

        while (head != null) {
            System.out.print(head.val);

            if (head.next != null) {
                System.out.print(" -> ");
            }

            head = head.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        // Create linked list
        // 1 -> 2 -> 3 -> 4 -> 5

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        // Reverse list
        head = reverseList(head);

        // Print reversed list
        printList(head);
    }
}