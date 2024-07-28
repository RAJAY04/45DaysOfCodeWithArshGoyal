package day14;

public class ReverseNodesInKGroup {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode res = reverseKGroup(head, 2);
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
    public static ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null)return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode dummyPtr = dummy;
        ListNode np = dummyPtr, sp = head;
        int len = 0;
        for(ListNode temp = head ; temp != null; temp = temp.next)len++;
        ListNode prev = null, cur = head, forward = cur;
        int n = len / k;
        for(int i = 0 ; i < n; i++){
            int temp = k;
            while(temp-- > 0){
                forward = cur.next;
                cur.next = prev;
                prev = cur;
                cur = forward;
            }
            np.next = prev;
            np = sp;
            sp.next = cur;
            sp = cur;
        }
        return dummy.next;
    }
}
