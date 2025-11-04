package Greedy;

public class leetcode_1578 {
    public int minCost(String colors, int[] neededTime) {
        return min(colors,neededTime);
    }

    int min(String s, int[]arr){
        int cost = 0;

        int currM = 0;
        for(int i = 0;i<s.length();i++){
            if(i>0 && s.charAt(i) != s.charAt(i-1)){
                currM = 0;
            }
            int curr = arr[i];
            cost += Math.min(curr,currM);
            currM = Math.max(curr,currM);
        }

        return cost;
    }
}
