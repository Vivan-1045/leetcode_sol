package LinkedList;

public class leetcode_143 {

    //Question https://leetcode.com/problems/reorder-list/
    public void reorderList(ListNode head) {
        if(head == null || head.next == null){
            return;
        }
        ListNode midList = getMid(head);
        ListNode end = reverseList(midList);
        ListNode start = head;

        while(end != null && start != null){
            ListNode temp = start.next;
            start.next = end;
            start = temp;

            temp = end.next;
            end.next = start;
            end = temp;
        }

        if(start != null){
            start.next = null;
        }

    }
    ListNode getMid(ListNode temp){
        ListNode s = temp;
        ListNode f = temp;

        while(f != null && f.next != null){
            s = s.next;
            f = f.next.next;
        }
        return s;
    }
    ListNode reverseList(ListNode head){
        if(head == null){
            return head;
        }

        ListNode prev = null;
        ListNode pres = head;
        ListNode next = pres.next;

        while(pres != null){
            pres.next = prev;
            prev = pres;
            pres = next;

            if(next != null){
                next = next.next;
            }
        }
        return prev;
    }
}
