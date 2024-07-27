package day13;

import java.util.List;

public class AddTwoNumbersII {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(7);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        l1.next.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        ListNode res = addTwoNumbers(l1,l2);
        while(res != null){
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

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int len1 = 0 , len2 = 0;
        for(ListNode i1 = l1; i1 != null ; i1 = i1.next)len1++;
        for(ListNode i2 = l2; i2 != null ; i2 = i2.next)len2++;
        ListNode head = null;
        while(l1 != null || l2 != null){
            int val1 = 0 , val2 = 0;
            if(len1 > len2){
                val1 = l1 == null? 0 : l1.val;
                l1 = l1.next;
                len1--;
            }else if(len2 > len1){
                val2 = l2 == null ? 0 : l2.val;
                l2 = l2.next;
                len2--;
            }else{
                val1 = l1 == null? 0 : l1.val;
                val2 = l2 == null ? 0 : l2.val;
                len1--;
                len2--;
                l1 = l1.next;
                l2 = l2.next;
            }
            ListNode node = new ListNode(val1 + val2);
            node.next = head;
            head = node;
        }
        int carry = 0;
        ListNode cur = head, prev = null, forward;
        while(cur != null){
            forward = cur.next;
            cur.val += carry;
            carry = cur.val / 10;
            cur.val %= 10;
            cur.next = prev;
            prev = cur;
            cur = forward;
        }
        if(carry > 0){
            ListNode node = new ListNode(carry);
            node.next = prev;
            return node;
        }
        return prev;
    }
}
