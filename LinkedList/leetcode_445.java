package LinkedList;


import java.util.Stack;

public class leetcode_445 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwo(l1,l2);
    }
    ListNode addTwo(ListNode l1 ,ListNode l2){
        ListNode ans  = null;
        Stack<Integer> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();

        while (l1 != null){
            st1.push(l1.val);
            l1 = l1.next;
        }

        while (l2 != null){
            st2.push(l2.val);
            l2 = l2.next;
        }

        int carry = 0;
        while(!st1.isEmpty() || !st2.isEmpty()||carry>0){
            int sum = carry;

            if(!st1.isEmpty()) sum +=st1.pop();
            if (!st2.isEmpty()) sum += st2.pop();
            carry = sum/10;

            //Adding the node in reverse order
            ListNode curr = new ListNode(sum%10);

            //Add the node in back of previously added node
            curr.next = ans;

            //Now ans will point to the curr
            ans = curr;

        }

        return ans;

    }

}
