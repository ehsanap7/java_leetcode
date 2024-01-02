package linkedlist;

import java.util.List;

public class Test {

    public int getSumNormal(ListNode head) {
        int ans = 0;
        while (head != null) {
            ans = head.val;
            head = head.next;
        }
        return ans;
    }

    public int getSumRecursive(ListNode head) {
        if (head == null) {
            return 0;
        }
        return head.val + getSumNormal(head.next);
    }

    public ListNode deleteLinkedList(ListNode head, int value) {
        if (head.val == value) {
            return head.next;
        }
        ListNode ans = head;
        ListNode prev = null;
        while (head != null) {
            if (head.val == value) {
                prev.next = prev.next.next;
            }
            prev = head;
            head = head.next;
        }
        return ans;
    }

    public int middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow.val;
    }

    public boolean cycleLinkedList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    public int kBeforeEnd(ListNode head, int k) {
        ListNode slow = head;
        ListNode fast = head;
        for (int i = 0; i <= k; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow.val;

    }

    public ListNode removeDuplicate(ListNode head) {
        ListNode dummy = head;
        while (head != null && head.next != null) {
            if (head.val == head.next.val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }
        return dummy;
    }

    public ListNode getSecondMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            if (fast.next.next == null) {
                return slow;
            }
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode reverseLinkedList(ListNode head) {

        ListNode prev = null;

        while (head != null) {
            ListNode nextNode = head.next;
            head.next = prev;
            prev = head;
            head = nextNode;
        }

        return prev;

    }

    public ListNode swapListNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = null;

         ListNode dummy = head.next;

        while (head != null && head.next != null) {
            if (prev != null) {
                prev.next = head.next;
            }

            prev = head;

            ListNode nextNode = head.next.next;
            head.next.next = head;

            head = nextNode;
            head.next = nextNode;
        }
        return dummy;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode forth = new ListNode(4);
        ListNode fifth = new ListNode(5);
        ListNode sixth = new ListNode(6);
        ListNode seventh = new ListNode(7);
        head.next = second;
        second.next = third;
        third.next = forth;
        forth.next = fifth;
        fifth.next = sixth;
        sixth.next = seventh;
        System.out.println(new Test().swapListNode(head));
    }

}
