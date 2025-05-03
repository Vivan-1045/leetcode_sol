package LinkedList;
class ListNode{
    int val;
    ListNode next;

    ListNode(int x){
        val = x;
        next = null;
    }

    public ListNode() {
    }
}
public class leetcode_148 {

    //Using Merge sort
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode mid = getMid(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);

        return merge(left,right);
    }
    public static ListNode merge( ListNode first, ListNode second){
       ListNode newHead = new ListNode();
       ListNode tail = newHead;

        while (first != null && second != null){
            if (first.val<second.val){
                tail.next = first;
                first = first.next;
                tail = tail.next;
            }else {
                tail.next = second;
                second = second.next;
                tail = tail.next;
            }
        }
        tail.next = (first != null)?first:second;
        return newHead.next;
    }

    public ListNode getMid(ListNode temp){
       ListNode fast = temp;
       ListNode slow = temp;
       ListNode prev = null;

       while (fast != null && fast.next != null){
           prev = slow;
           slow = slow.next;
           fast = fast.next.next;
       }

       //It split the list into two sublist
       if (prev != null){
           prev.next = null;
       }
       return slow;
    }
}
