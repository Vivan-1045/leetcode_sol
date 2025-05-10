package Contests;

import java.util.HashMap;
import java.util.Map;

public class biweekly_156 {
    private static final Map<String, Integer> memo = new HashMap<>();
    public static void main(String[] args) {
        String s = "successes";
        int[]arr = {0,2};
        System.out.println(minOperations(arr));
//        System.out.println(maxFreq(s));
    }
    public static int maxFreq(String s){
        Map<Character , Integer> mp = new HashMap<>();
        int vowel = 0;
        int con = 0;
        for (int i =0;i<s.length();i++){
            mp.put(s.charAt(i),mp.getOrDefault(s.charAt(i),0)+1);
        }

        for (Map.Entry<Character,Integer> entry: mp.entrySet()){
            if (entry.getKey()=='a'||entry.getKey()=='e'||entry.getKey()=='i'||entry.getKey()=='o'||entry.getKey()=='u'){
                vowel = Math.max(vowel,entry.getValue());
            }
            else{
                con = Math.max(con, entry.getValue());
            }
        }
        return vowel+con;
    }
    public static  int minOperations(int[] nums) {
        int operations = 0;
        int n = nums.length;

        for (int i = 0; i < n; ) {
            if (nums[i] == 0) {
                i++;
                continue;
            }

            int min = nums[i];
            int j = i;

            while (j < n && nums[j] != 0) {
                min = Math.min(min, nums[j]);
                j++;
            }

            for (int k = i; k < j; k++) {
                if (nums[k] == min) nums[k] = 0;
            }

            operations++;
        }

        return operations;
    }
}
