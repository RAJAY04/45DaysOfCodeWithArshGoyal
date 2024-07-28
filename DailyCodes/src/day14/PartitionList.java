package day14;

import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class PartitionList {
    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(1);
        ListNode res = partition(head, 2);
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

        //simple idea all the element smaller than x into one list and larget into other
    //connect end of smaller list to start of larger and then point end of larger to null to avoid cycles.
    public static ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null)return head;
        ListNode smallerHead = new ListNode(-201);
        ListNode greaterHead = new ListNode(-201);
        ListNode sp = smallerHead, lp = greaterHead;
        for(ListNode temp = head; temp != null ; temp = temp.next){
            if(temp.val >= x){
                lp.next = temp;
                lp = lp.next;
            }else{
                sp.next = temp;
                sp = sp.next;
            }
        }
        sp.next = greaterHead.next;
        lp.next = null;
        return smallerHead.next;
    }
}
