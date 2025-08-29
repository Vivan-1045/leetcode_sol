package Two_Pointer;

import java.util.Stack;

public class leetcode_962 {
    public static void main(String[] args) {

    }

    //Brute Force 100/101
    public static int maxWidthRamp1(int[] arr){
        int max = -1;
        int n = arr.length;

        for(int i = 0;i<n;i++){
            int curr = 0;
            for(int j = n-1;j>i;j--){
                if(arr[i]<=arr[j]){
                    curr = j-i;
                    break;
                }
            }
            if(curr>max){
                max = curr;
            }
        }

        return max;
    }

    //Using stack
    int maxRamp2(int[] arr){
        int max = -1;
        int n = arr.length;

        Stack<Integer> st = new Stack<>();

        for(int i = 0;i<n;i++){
            if(st.isEmpty() || arr[i]<arr[st.peek()]){
                st.push(i);
            }
        }

        for(int j = n-1;j>=0;j--){
            while(!st.isEmpty() && arr[j]>=arr[st.peek()]){
                max = Math.max(max,j-st.peek());
                st.pop();
            }
        }

        return max;
    }
}
