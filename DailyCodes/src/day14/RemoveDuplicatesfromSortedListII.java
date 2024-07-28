package day14;

import java.util.List;

public class RemoveDuplicatesfromSortedListII {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        ListNode res = deleteDuplicates(head);
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
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-101);
        if(head == null || head.next == null)return head;
        dummy.next = head;
        ListNode prev = dummy, cur = head, forward = head.next;
        while(forward != null){
            if(cur.val == forward.val){
                while(cur.val == forward.val){
                    cur = forward;
                    forward = forward.next;
                    if(forward == null){
                        prev.next = null;
                        return dummy.next;
                    }
                }
                prev.next = forward;
                cur = forward;
                forward = forward.next;
            }else{
                prev = cur;
                cur = forward;
                forward = forward.next;
            }
        }
        return dummy.next;
    }
}
