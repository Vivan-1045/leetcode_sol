package LinkedList;

public class leetcode_234 {
    public boolean isPalindrome(ListNode head) {
        ListNode mid = getMid(head);
        ListNode secondHead = reverseList(mid);
        ListNode reReverse = secondHead;

        while(head != null && secondHead != null){
            if(head.val != secondHead.val){
                break;
            }
            head = head.next;
            secondHead = secondHead.next;
        }
        reverseList(reReverse);

        if(head == null || secondHead == null){
            return true;
        }
        return false;
    }
    ListNode getMid(ListNode temp){
        ListNode slow = temp;
        ListNode fast = temp;
        while(fast != null && fast.next != null){
            slow = slow.next ;
            fast= fast.next.next;
        }
        return slow;
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
