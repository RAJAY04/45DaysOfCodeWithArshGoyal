package day13;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class CopyListWithRandomPointer {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.random = head.next.next;
        head.next.random = head;
        head.next.next.random = head.next.next.next;
        head.next.next.next.random = head.next;
        head.next.next.next.next.random = head.next.next;
        Node res = copyRandomList1(head);
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }
    static class Node {
        int val;
        Node next;
        Node random;
        Node() {}
        Node(int val) { this.val = val; }
        Node(int val, Node next, Node random) { this.val = val; this.next = next; this.random = random; }
    }
    public static Node copyRandomList(Node head) {
        Map<Node,Node> map = new HashMap<>();
        Node dummy = new Node(-1);

        for(Node temp = head, dummyPtr = dummy; temp != null ; temp = temp.next){
            Node node = new Node(temp.val);
            map.put(temp,node);
            dummyPtr.next = node;
            dummyPtr = node;
        }

        for(Node temp = head, dummyPtr = dummy.next; temp != null; temp = temp.next,dummyPtr = dummyPtr.next){
            if(temp.random != null){
                dummyPtr.random = map.get(temp.random);
            }else dummyPtr.random = null;
        }
        return dummy.next;
    }

    public static Node copyRandomList1(Node head) {
        if(head == null)return head;
        insertInBtw(head);
        connectRandom(head);
        return seperateNodes(head);
    }
    public static void insertInBtw(Node head){
        for(Node temp = head; temp != null; temp = temp.next.next){
            Node node = new Node(temp.val);
            node.next = temp.next;
            temp.next = node;
        }
    }
    public static void connectRandom(Node head){
        for(Node temp = head; temp != null ; temp = temp.next.next){
            if(temp.random != null){
                temp.next.random = temp.random.next;
            }else temp.next.random = null;
        }
    }
    public static Node seperateNodes(Node head){
        Node dummy = new Node(-1);
        Node dummyPtr = dummy;
        for(Node temp = head; temp != null; temp = temp.next){
            dummyPtr.next = temp.next;
            dummyPtr = dummyPtr.next;
            temp.next = temp.next.next;
        }
        return dummy.next;
    }
}
