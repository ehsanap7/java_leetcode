package linkedlist;

public class SwapNodes {

    public ListNode swapNode(ListNode head, int k) {
        ListNode dummy = new ListNode(0, head);

        ListNode slow = dummy;
        ListNode fast = dummy;

        for (int i = 0; i < k; i++) {
            slow = slow.next;
        }

        ListNode fastHelp = slow.next;

        while (fastHelp != null) {
            fastHelp = fastHelp.next;
            fast = fast.next;
        }

        fast = fast.next;

        int temp = slow.val;
        slow.val = fast.val;
        fast.val = temp;

        return dummy.next;
    }

    public static void main(String[] args) {
        //        int[] arr = {47, 22, 81, 46, 94, 95, 90, 22, 55, 91, 6, 83, 49, 65, 10, 32, 41, 26, 83, 99, 14, 85, 42, 99, 89, 69, 30, 92, 32, 74, 9, 81, 5, 9};
        int[] arr = {1, 2, 3, 4, 5};

        ListNode head = new ListNode(arr[0]);
        ListNode current = head;

        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }

        System.out.println(new SwapNodes().swapNode(head, 2));
    }

}
