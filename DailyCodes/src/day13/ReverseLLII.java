package day13;

public class ReverseLLII {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode res = reverseBetween(head, 2, 4);
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode leftPrev = dummy;

        for (int i = 1; i < left; i++) {
            leftPrev = leftPrev.next;
        }

        ListNode leftNode = leftPrev.next;
        ListNode prev = null;
        ListNode cur = leftNode;


        for (int i = 0; i <= right - left; i++) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        leftPrev.next = prev;
        leftNode.next = cur;

        return dummy.next;
    }
}
