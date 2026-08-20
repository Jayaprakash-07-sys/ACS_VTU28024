public class PalindromeLinkedList {

    // Definition of Linked List Node
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    // Method to check whether the linked list is a palindrome
    public static boolean isPalindrome(ListNode head) {

        if (head == null || head.next == null) {
            return true;
        }

        // Find the middle of the linked list
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse the second half
        ListNode secondHalf = reverse(slow);

        // Compare first half and reversed second half
        ListNode firstHalf = head;
        ListNode temp = secondHalf;

        while (temp != null) {
            if (firstHalf.val != temp.val) {
                return false;
            }

            firstHalf = firstHalf.next;
            temp = temp.next;
        }

        return true;
    }

    // Method to reverse a linked list
    public static ListNode reverse(ListNode head) {

        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }

    public static void main(String[] args) {

        // Creating linked list:
        // 1 -> 2 -> 2 -> 1
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);

        // Check palindrome
        boolean result = isPalindrome(head);

        System.out.println(result);
    }
}