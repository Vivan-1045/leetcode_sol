package Easy;

import java.util.HashMap;
import java.util.Map;

public class leetcode_1399 {
    public static void main(String[] args) {
        System.out.println(maxLengthGrouped(9));
    }
    public static int maxLengthGrouped(int n){
        int count = 0;
        Map<Integer,Integer> mp = new HashMap<>();

        for (int i = 1;i<=n;i++){
            int digitSum = findDigitSum(i);
            mp.put(digitSum,mp.getOrDefault(digitSum,0)+1);
        }

        int currFreq = 0;
        for (Map.Entry<Integer,Integer> entry : mp.entrySet()){

            if (entry.getValue()>currFreq ){
                currFreq = entry.getValue();
                count = 1;
                continue;
            }
            if (entry.getValue() == currFreq){
                count += 1;
            }
        }
        return count;
    }

    private static int findDigitSum(int i) {
        if (i == 0){
            return 0;
        }
        return i%10 + findDigitSum(i/10);
    }
}
