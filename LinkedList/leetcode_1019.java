package LinkedList;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class leetcode_1019 {

     public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

    public int[] nextLargerNodes(ListNode head) {
        return nextGreaterNode(head);
    }

    //Using two pointer
    int[] nextGreaterNode(ListNode head){
        ListNode s = head;

        Stack<Integer> st = new Stack<>();
        while(s != null){
            int val = s.val;
            ListNode s1 = s.next;
            while(s1 != null){
                if(val<s1.val){
                    st.add(s1.val);
                    break;
                }
                s1= s1.next;
            }
            if(s1 == null){
                st.add(0);
            }

            s=s.next;
        }


        int []ans = new int[st.size()];
        int i =st.size()-1;
        while(!st.isEmpty()){
            ans[i--]=st.pop();
        }
        return ans;
    }

    //Using Monotonic stack
    int[] nextGreaterNode1(ListNode head){
        List<Integer> list = new ArrayList<>();
        ListNode s = head;

        while(s != null){
            list.add(s.val);
            s=s.next;
        }

        Stack<Integer> st = new Stack<>();
        int[] ans = new int[list.size()];
        for(int i = list.size()-1;i>=0;i--){

            while(!st.isEmpty() && st.peek()<=list.get(i)){
                st.pop();
            }

            if(st.isEmpty()){
                ans[i]=0;
            }else{
                ans[i]=st.peek();
            }
            st.push(list.get(i));
        }

        return ans;
    }
}
