package LinkedList;

public class leetcode_25 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        return kGroupReverse(head,k);
    }
    ListNode kGroupReverse(ListNode head , int k){
        if (head==null|| k<=1){
            return head;
        }
        int len = 0;
        ListNode temp = head;
        while (temp != null){
            temp = temp.next;
            len++;
        }
        ListNode prev = null;
        ListNode current = head;
        while (true){
            ListNode last = prev;
            ListNode newNode = current;

            assert false;
            ListNode next = current.next;
            for(int i = 0;current != null && i< k;i++){
                current.next = prev;
                prev = current;
                current = next ;
                if(next != null){
                    next = next.next;
                }
                len -= 1;
                if (len<k){
                    break;
                }
            }

            if(last != null){
                last.next = prev;
            }else {
                head = prev;
            }

            newNode.next = current;
            if (current==null){
                break;
            }

            prev = newNode;
        }
        return head;
    }
}
