package day14;

import java.util.List;

public class SortList {
    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);
        ListNode res = sortList(head);
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

    public static ListNode sortList(ListNode head) {
        return mergeSort(head);
    }

    public static ListNode mergeSort(ListNode head){
        if(head == null || head.next == null)return head;
        ListNode mid = getMid(head);
        ListNode midNext = mid.next;
        mid.next = null;
        ListNode left = mergeSort(head);
        ListNode right = mergeSort(midNext);
        return merge(left , right);
    }

    public static ListNode merge(ListNode left, ListNode right){
        ListNode dummy = new ListNode(-1);
        ListNode ptr = dummy;
        while(left != null && right != null){
            if(left.val > right.val){
                ptr.next = right;
                right = right.next;
            }else {
                ptr.next = left;
                left = left.next;
            }
            ptr = ptr.next;
        }

        if(left != null){
            ptr.next = left;
        }else{
            ptr.next = right;
        }
        return dummy.next;
    }

    public static ListNode getMid(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode slow = head, fast = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
