package day13;

public class RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode res = removeNthFromEnd(head, 2);
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
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        int len = 0;
        for(ListNode temp = head; temp != null ;temp = temp.next)len++;
        if(n == len)return head.next;
        ListNode temp = head;
        for(int i = 1; i < len - n; i++){
            temp = temp.next;
        }
        if(temp.next.next != null)
            temp.next = temp.next.next;
        else temp.next = null;
        return head;
    }
}
