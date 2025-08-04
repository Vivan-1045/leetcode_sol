package LinkedList;

import java.util.PriorityQueue;

public class leetcode_23 {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
   }

    public ListNode mergeKLists(ListNode[] lists) {
        return allSorted(lists);
    }

    ListNode allSorted(ListNode[] lists){
        if(lists==null || lists.length==0){
            return null;
        }


        ListNode head = new ListNode(0);
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(ListNode list : lists){
            while(list != null){
                pq.add(list.val);
                list = list.next;
            }
        }

        ListNode dummy = head;

        while(!pq.isEmpty()){
            dummy.next = new ListNode(pq.poll());
            dummy = dummy.next;
        }

        return head.next;
    }
}
