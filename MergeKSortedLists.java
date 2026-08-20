import java.util.PriorityQueue;

public class MergeKSortedLists {

    // Definition for singly-linked list
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public static ListNode mergeKLists(ListNode[] lists) {

        if (lists == null || lists.length == 0) {
            return null;
        }

        // Min-heap based on node value
        PriorityQueue<ListNode> pq =
                new PriorityQueue<>((a, b) -> a.val - b.val);

        // Add first node of every list
        for (ListNode list : lists) {
            if (list != null) {
                pq.offer(list);
            }
        }

        // Dummy node
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        // Merge all lists
        while (!pq.isEmpty()) {

            ListNode node = pq.poll();

            current.next = node;
            current = current.next;

            // Add next node from the same list
            if (node.next != null) {
                pq.offer(node.next);
            }
        }

        return dummy.next;
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

        // List 1: 1 -> 4 -> 5
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(4);
        list1.next.next = new ListNode(5);

        // List 2: 1 -> 3 -> 4
        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        // List 3: 2 -> 6
        ListNode list3 = new ListNode(2);
        list3.next = new ListNode(6);

        ListNode[] lists = {list1, list2, list3};

        // Merge k lists
        ListNode result = mergeKLists(lists);

        // Print result
        printList(result);
    }
}