package linkedlist;

public class ReverseBetween {

    public ListNode reverseBetween(ListNode head, int left, int right) {

        ListNode dummy = new ListNode(0, head);
        ListNode prevNode = dummy;

        for (int i = 1; i < left; i++) {
            prevNode = prevNode.next;
        }

        ListNode curr = prevNode.next;
        ListNode prev = prevNode;

        for (int i = left; i <= right; i++) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        prevNode.next.next = curr;
        prevNode.next = prev;

        return dummy.next;

    }

    public static void main(String[] args) {
//        int[] arr = {47, 22, 81, 46, 94, 95, 90, 22, 55, 91, 6, 83, 49, 65, 10, 32, 41, 26, 83, 99, 14, 85, 42, 99, 89, 69, 30, 92, 32, 74, 9, 81, 5, 9};
        int[] arr = {3, 5};

        ListNode head = new ListNode(arr[0]);
        ListNode current = head;

        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }

        System.out.println(new ReverseBetween().reverseBetween(head, 1, 2));
    }

}
