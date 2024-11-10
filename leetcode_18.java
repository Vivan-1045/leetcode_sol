import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode_18 {
    public static void main(String[] args) {
        int[] nums = {1000000000,1000000000,1000000000,1000000000};
        int target = -294967296;
        Arrays.sort( nums);
        List<List<Integer>> result = new ArrayList<>();
        for(int i =0; i< nums.length-3;i++){
            if (i>0&& nums[i] ==  nums[i-1]) continue;
            for(int j =i+1;j< nums.length-2;j++){
                if (j>i+1&&  nums[j] == nums[j-1]) continue;
                int s = j+1;
                int e =  nums.length-1;
                while(s<e){
                    long sum =  (long)nums[i]+ nums[j]+ nums[s]+ nums[e];
                    if(sum==target){
                        result.add(Arrays.asList( nums[i], nums[j], nums[s], nums[e]));
                        s++;
                        e--;
                    }else if(sum<target){
                        s++;
                    }else{
                        e--;
                    }
                }
            }

        }
        System.out.println(new ArrayList<>(result));
    }

}
