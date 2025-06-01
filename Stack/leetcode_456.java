package Stack;

import java.util.Stack;

public class leetcode_456 {
    public static void main(String[] args) {
        int[] arr = {3,1,4,2};
        System.out.println(solve(arr));
    }
    public static boolean solve(int[] arr){
        int c = Integer.MIN_VALUE;
        Stack<Integer> st = new Stack<>();

        for (int i = arr.length-1;i>=0;i--){
            if (arr[i]<c){
                return true;
            }
            while (!st.isEmpty() && st.peek()<arr[i]){
                c = st.peek();
                st.pop();
            }
            st.push(arr[i]);
        }
        return false;
    }
}
