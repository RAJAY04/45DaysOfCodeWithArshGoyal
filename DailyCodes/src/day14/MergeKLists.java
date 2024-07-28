package day14;

import java.util.PriorityQueue;

public class MergeKLists {
    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(4);
        head1.next.next = new ListNode(5);
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(3);
        head2.next.next = new ListNode(4);
        ListNode head3 = new ListNode(2);
        head3.next = new ListNode(6);
        ListNode[] lists = new ListNode[]{head1, head2, head3};
        ListNode res = mergeKLists1(lists);
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

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>((a, b) -> a.val - b.val);

        // Add the head of each non-null list to the priority queue
        for (ListNode node : lists) {
            if (node != null) {
                priorityQueue.add(node);
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode dummyPtr = dummy;

        while (!priorityQueue.isEmpty()) {
            ListNode node = priorityQueue.poll();
            dummyPtr.next = node;
            dummyPtr = dummyPtr.next;

            // If the polled node has a next node, add it to the priority queue
            if (node.next != null) {
                priorityQueue.add(node.next);
            }
        }

        // Ensure the last node points to null to prevent cycles
        dummyPtr.next = null;

        return dummy.next;
    }

    public static ListNode mergeKLists1(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        ListNode dummy = new ListNode(-1);
        ListNode dummyPtr = dummy;

        for (ListNode node : lists) {
            if (node == null) continue;
            dummyPtr.next = node;
            ListNode temp = node;
            while (temp.next != null) temp = temp.next;
            dummyPtr = temp;
        }

        return sortList(dummy.next);
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


