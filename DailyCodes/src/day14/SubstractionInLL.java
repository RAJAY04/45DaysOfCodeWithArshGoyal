package day14;

public class SubstractionInLL {
    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.next = new Node(0);
        head1.next.next = new Node(1);
        head1.next.next.next = new Node(0);
        head1.next.next.next.next = new Node(0);
        head1.next.next.next.next.next = new Node(0);
        Node head2 = new Node(9);
        head2.next = new Node(9);
        Node res = subLinkedList(head1, head2);
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }
    //solve this again
    public static Node subLinkedList(Node head1, Node head2) {
        int num1 = 0, num2 = 0;
        //converting linked list to number
        for (Node temp = head1; temp != null; temp = temp.next) {
            num1 = num1 * 10 + temp.val;
        }
        for (Node temp = head2; temp != null; temp = temp.next) {
            num2 = num2 * 10 + temp.val;
        }
        int diff = num1 - num2;
        //converting number to linked list
        Node dummy = new Node(-1);
        Node ptr = dummy;
        if (diff == 0) {
            ptr.next = new Node(0);
            return dummy.next;
        }
        while (diff > 0) {
            int rem = diff % 10;
            ptr.next = new Node(rem);
            ptr = ptr.next;
            diff /= 10;
        }
        return dummy.next;
    }

    // Definition for singly-linked list node
    public static class Node {
        int val;
        Node next;

        Node(int x) {
            val = x;
            next = null;
        }
    }
}