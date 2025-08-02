package unCategorisedCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode_1365 {
    public static void main(String[] args) {
        int []nums = {6,5,4,11};
        List<Integer> result = new ArrayList<>();
//        int count = 0;
        for (int i =0;i<nums.length;i++){
            int count = 0;
            for(int j = 0; j<nums.length;j++){
                if(nums[i]>nums[j] && i!=j){
                    count += 1;

                }
//                System.out.println(count);

            }
            result.add(count);
        }

        Integer[] resultArray = result.toArray(new Integer[0]);
        System.out.println(Arrays.toString(resultArray));
    }
}
