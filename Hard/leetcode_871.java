package Hard;

import java.util.PriorityQueue;

public class leetcode_871 {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        return solve(target,startFuel,stations);
    }

    int solve(int tar, int stFuel , int[][]st){
        int n = st.length;

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b-a);

        for(int[]a : st){
            int currPos = a[0];
            int fuel = a[1];

            while(stFuel<currPos){
                if(pq.isEmpty()){
                    return -1;
                }

                stFuel += pq.poll();
            }

            pq.offer(fuel);
        }

        while(stFuel<tar){
            if(pq.isEmpty()){
                return -1;
            }

            stFuel += pq.poll();
        }

        return n - pq.size();
    }
}
