package LinkedList;

public class leetcode_2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addNumbers(l1,l2);
    }
    public static ListNode addNumbers(ListNode h1,ListNode h2){
        ListNode ans = new ListNode(0);
        ListNode dummy = ans;
        ListNode temp1 = h1;
        ListNode temp2 = h2;
        int carry = 0;

        while(temp1 != null && temp2 != null){
            int sum = temp1.val + temp2.val +carry;
            int value = sum%10;
            carry = sum/10;
            dummy.next = new ListNode(value);
            dummy = dummy.next;
            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        while(temp1 != null){
            int sum = temp1.val + carry;
            int value = sum%10;
            carry = sum/10;
            dummy.next = new ListNode(value);
            dummy = dummy.next;
            temp1 = temp1.next;
        }

        while(temp2 != null){
            int sum = temp2.val + carry;
            int value = sum%10;
            carry = sum/10;
            dummy.next = new ListNode(value);
            dummy = dummy.next;
            temp2 = temp2.next;
        }

        if(carry<10 && carry!=0){
            dummy.next = new ListNode(carry);
            return ans.next;
        }
        return ans.next;
    }
}
