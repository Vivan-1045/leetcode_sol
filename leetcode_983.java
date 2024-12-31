import java.util.*;

public class leetcode_983 {
    public static void main(String[] args) {
        int days[] = {1,2,4,6,5,7,8,9,20};
        int cost[] = {2,7,15};
        System.out.println(MinCost(days,cost));
    }
    public static int MinCost(int[]days,int[]costs){
        Set<Integer> st = new HashSet<>();
        for (int in: days) {
            st.add(in);
        }
        int minCost[] = new int[days[days.length-1]+1];
        int last_day = days[days.length-1];
        Arrays.fill(minCost,0);
        minCost[0]=0;

        for (int i = 1;i<=last_day;i++){
           if (!st.contains(i)){
               minCost[i] = minCost[i-1];
               continue;
           }
           int pass_1 = costs[0] + minCost[Math.max(i-1,0)];
           int pass_7 = costs[1] + minCost[Math.max(i-7,0)];
           int pass_30 = costs[2]+minCost[Math.max(i-30,0)];

           minCost[i] = Math.min(Math.min(pass_1, pass_7),pass_30);

        }
        return minCost[last_day];
    }


}
