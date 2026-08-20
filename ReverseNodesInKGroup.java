public class ReverseNodesInKGroup {

    // Definition of ListNode
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public static ListNode reverseKGroup(ListNode head, int k) {

        if (head == null || k == 1) {
            return head;
        }

        // Dummy node
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode groupPrev = dummy;

        while (true) {

            // Find the kth node
            ListNode kth = getKthNode(groupPrev, k);

            // If there are fewer than k nodes left
            if (kth == null) {
                break;
            }

            ListNode groupNext = kth.next;

            // Reverse the group
            ListNode prev = groupNext;
            ListNode current = groupPrev.next;

            while (current != groupNext) {

                ListNode next = current.next;
                current.next = prev;
                prev = current;
                current = next;
            }

            // Connect previous part to reversed group
            ListNode temp = groupPrev.next;
            groupPrev.next = kth;

            // Move groupPrev to the end of reversed group
            groupPrev = temp;
        }

        return dummy.next;
    }

    // Find kth node from groupPrev
    private static ListNode getKthNode(ListNode current, int k) {

        while (current != null && k > 0) {
            current = current.next;
            k--;
        }

        return current;
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

        int k = 2;

        // Reverse nodes in groups of k
        head = reverseKGroup(head, k);

        // Print result
        printList(head);
    }
}