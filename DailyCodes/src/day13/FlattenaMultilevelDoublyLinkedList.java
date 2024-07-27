package day13;

public class FlattenaMultilevelDoublyLinkedList {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.prev = head;
        head.next.next = new Node(3);
        head.next.next.prev = head.next;
        head.next.next.next = new Node(4);
        head.next.next.next.prev = head.next.next;
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.prev = head.next.next.next;
        head.next.next.child = new Node(6);
        head.next.next.child.next = new Node(7);
        head.next.next.child.next.prev = head.next.next.child;
        head.next.next.child.next.next = new Node(8);
        head.next.next.child.next.next.prev = head.next.next.child.next;
        head.next.next.child.next.next.next = new Node(9);
        head.next.next.child.next.next.next.prev = head.next.next.child.next.next;
        head.next.next.child.next.next.child = new Node(10);
        head.next.next.child.next.next.child.prev = head.next.next.child.next.next;
        flatten(head);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
        static class Node {
            public int val;
            public Node prev;
            public Node next;
            public Node child;

            public Node() {}

            public Node(int val) {
                this.val = val;
            }

            public Node(int val, Node prev, Node next, Node child) {
                this.val = val;
                this.prev = prev;
                this.next = next;
                this.child = child;
            }
        }
//    public static Node flatten(Node head) {
//        for(Node temp = head; temp != null; temp = temp.next){
//            if(temp.child != null){
//                Node node = dfs(temp.child,temp.next);
//                temp.next = node;
//                if (node != null) {
//                    node.prev = temp;
//                }
//                temp.child = null;
//                break;
//            }
//        }
//        return head;
//    }
//    public static Node dfs(Node head,Node parent){
//        for(Node temp = head; temp != null ; temp = temp.next){
//            if(temp.child != null){
//                Node node = dfs(temp.child,temp.next);
//                temp.next = node;
//                node.prev = temp;
//                temp.child = null;
//            }
//            if(temp.next == null){
//                temp.next = parent;
//                if (parent != null) {
//                    parent.prev = temp;
//                }
//                return head;
//            }
//        }
//        return head;
//    }

    public static Node flatten(Node head) {
        Node h = head;
        while(h != null){
            if(h.child == null){
                h = h.next;
                continue;
            }

            Node temp = h.child;
            while(temp.next != null)temp = temp.next;

            temp.next = h.next;
            if(h.next != null)h.next.prev = temp;

            h.next = h.child;
            h.child.prev = h;
            h.child = null;
            h = h.next;

        }
        return head;
    }
}
