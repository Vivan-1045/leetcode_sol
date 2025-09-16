package Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class leetcode_2197 {
    public static void main(String[] args) {
       int[] arr = {287,41,49,287,899,23,23,20677,5,825};
        System.out.println(finalArray(arr));
    }
    public static List<Integer> finalArray(int[] arr){
        if(arr.length<2){
            List<Integer> list = new ArrayList<>();
            list.add(arr[0]);
            return list;
        }
        Stack<Integer> st = new Stack<>();
        st.push(arr[0]);

        for(int i = 1;i<arr.length;i++){
            int curr = arr[i];
            while(!st.isEmpty()){
                int temp = st.peek();
                int gcd = getGCD(temp,curr);

                if(gcd==1){
                    break;
                }

                curr = getLcm(curr,temp);
                st.pop();
            }

            st.push(curr);
        }

        List<Integer> ans = new ArrayList<>(st.size());

        while(!st.isEmpty()){
            ans.add(0,st.pop());
        }

        return ans;
    }

    public static int getGCD(int x, int y){
        if(x==0){
            return y;
        }

        return getGCD(y%x,x);
    }

    public static int getLcm(int x, int y){
        return (x/getGCD(x,y))*y;
    }
}
