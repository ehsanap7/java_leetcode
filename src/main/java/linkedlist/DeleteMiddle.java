package linkedlist;

public class DeleteMiddle {

    public ListNode deleteMiddle(ListNode head) {

        if (head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0, head);

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        while (head.next != null) {
            if (head.next == slow) {
                head.next = head.next.next;
                break;
            } else {
                head = head.next;
            }
        }

        return dummy.next;
    }

    public static void main(String[] args) {
//        int[] arr = {47, 22, 81, 46, 94, 95, 90, 22, 55, 91, 6, 83, 49, 65, 10, 32, 41, 26, 83, 99, 14, 85, 42, 99, 89, 69, 30, 92, 32, 74, 9, 81, 5, 9};
        int[] arr = {1};

        ListNode head = new ListNode(arr[0]);
        ListNode current = head;

        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }

        System.out.println(new DeleteMiddle().deleteMiddle(head));
    }

}
