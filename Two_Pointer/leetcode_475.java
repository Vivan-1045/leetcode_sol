package Two_Pointer;

import java.util.*;

public class leetcode_475 {
    public static void main(String[] args) {
        int[] houses = {1};
        int [] heater = {1};
        System.out.println(minRadius(houses,heater));
    }
    public static int minRadius(int[]houses,int[]heater){
        List<Integer> minDis = new ArrayList<>();
        int ans = 0;
        Arrays.sort(heater);
        for (int i = 0;i<houses.length;i++){
            minDis.add(findMinRad(houses[i],heater));
        }
        for(int num : minDis){
            ans = Math.max(ans,num);
        }
        return ans;
    }

    public static int findMinRad(int num , int [] heater){
        if (num>=heater[heater.length-1]){
            return num-heater[heater.length-1];
        }
        if (num<=heater[0]){
            return heater[0]-num;
        }
        for (int i = 0;i<heater.length;i++){
            if (num<=heater[i] && i>0){
                return Math.min(num-heater[i-1],heater[i]-num);
            }
        }
        return 0;
    }

}
