package Graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class gfg_min_multi_yo_reach_end {
    class Pair{
        int step;
        int node;
        Pair(int a, int b){
            this.step=a;
            this.node=b;
        }
    }

    int minimumMultiplications(int[] arr, int start, int end) {

        return minMulti(arr, start,end);
    }

    int minMulti(int[]arr, int start, int end){
        int []dist = new int[100000];

        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[start] = 0;

        Queue<Pair> qu = new LinkedList<>();
        qu.offer(new Pair(0,start));

        while(!qu.isEmpty()){
            int step = qu.peek().step;
            int node = qu.peek().node;
            qu.poll();

            if(node==end){
                return step;
            }

            for(int ele : arr){
                int mul = node*ele;
                mul = mul%100000;
                if(dist[mul]>step+1){
                    dist[mul] = step+1;
                    qu.offer(new Pair(step+1,mul));
                }
            }
        }

        return -1;
    }
}
