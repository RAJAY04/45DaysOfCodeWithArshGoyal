package day12;

public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
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
        ListNode res = new ListNode(-1);
        ListNode head = res;
        int carry = 0;
        while(l1 != null && l2 != null){
            int sum = l1.val + l2.val + carry;
            carry = sum / 10;
            ListNode node = new ListNode(sum % 10);
            head.next = node;
            head = head.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1 != null){
            int sum = l1.val  + carry;
            carry = sum / 10;
            ListNode node = new ListNode(sum % 10);
            head.next = node;
            head = head.next;
            l1 = l1.next;
        }
        while(l2 != null){
            int sum = l2.val + carry;
            carry = sum / 10;
            ListNode node = new ListNode(sum % 10);
            head.next = node;
            head = head.next;
            l2 = l2.next;
        }
        if(carry > 0)head.next = new ListNode(carry);
        return res;
    }
}
