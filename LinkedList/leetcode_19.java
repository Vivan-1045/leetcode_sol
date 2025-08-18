package LinkedList;

public class leetcode_19 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        return finalList(head,n);
    }
    ListNode finalList(ListNode head, int n){
        int len = 0;
        ListNode temp = head;
        while(temp != null){
            len++;
            temp = temp.next;
        }

        if(len==n){
            return head.next;
        }

        temp = head;
        for(int i = 1;i<len-n;i++){
            temp = temp.next;
        }

        if(n==1){
            temp.next = null;
        }else{
            temp.next = temp.next.next;
        }
        return head;
    }
}
