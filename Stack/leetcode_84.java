package Stack;

import java.util.Stack;

public class leetcode_84 {
    public static void main(String[] args) {
        int []height = {2,1,5,6,2,3};
        System.out.println(getLargestRectangle(height));
    }
    public static int getLargestRectangle(int[] height){
        int max = 0;
        Stack<Integer> st = new Stack<>();
        st.push(0);

        for (int i = 1;i<height.length;i++){
            while (!st.isEmpty()&& height[i]<height[st.peek()]){
                max = getMax(st,height,max,i);
            }

            st.push(i);
        }

        int i = height.length;
        while (!st.isEmpty()){
            max = getMax(st,height,max,i);
        }

        return max;
    }

    public static int getMax(Stack<Integer> st, int[] arr,int max,int i){
        int area;
        int popped = st.pop();

        if (st.isEmpty()){
            area = arr[popped] * i;
        }else{
            area = arr[popped] * (i-1-st.peek());
        }
        return Math.max(max,area);
    }

}
