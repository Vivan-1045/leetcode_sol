package Contests;

import java.util.*;

public class biweekly_158 {
    public static void main(String[] args) {

    }

    //Question 1.
    public static int maxSum(int[]x , int[] y){
        int sum = 0;
        Map<Integer,Integer> maxIndex = new HashMap<>();
        for (int i= 0;i<x.length;i++){
            maxIndex.put(x[i],Math.max(maxIndex.getOrDefault(x[i],0),y[i]));
        }

        List<Integer> maxSumOfY = new ArrayList<>(maxIndex.values());
        Collections.sort(maxSumOfY,Collections.reverseOrder());

        if (maxSumOfY.size() < 3) {
            return -1;
        }
        sum = maxSumOfY.get(0)+maxSumOfY.get(1)+maxSumOfY.get(2);

        return sum;
    }
}
