package Maths;

import java.util.PriorityQueue;

public class leetcode_1792 {
    static class Pair{
        double delta;
        int idx;
        Pair(double val, int idx){
            this.delta = val;
            this.idx = idx;
        }
    }

    public static void main(String[] args) {
        int[][] arr = {{2,4},{3,9},{4,5},{2,10}};
        System.out.println(maxAvg(arr,4));
    }

    public static double maxAvg(int[][] classes,int extraStu){
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b)->Double.compare(b.delta,a.delta));
        int i = 0;
        for(int[] stu : classes){
            double PR = (double)stu[0]/stu[1];
            double NewPR = (double)(stu[0]+1)/(stu[1]+1);
            double delta = NewPR - PR;
            pq.offer(new Pair(delta,i++));
        }

        while(extraStu-->0){
            Pair curr = pq.poll();
            int idx = curr.idx;

            classes[idx][0]+=1;
            classes[idx][1]+=1;

            double PR = (double)classes[idx][0]/classes[idx][1];
            double NewPR = (double)(classes[idx][0]+1)/(classes[idx][1]+1);

            double delta = NewPR-PR;
            pq.offer(new Pair(delta,idx));
        }

        double res = 0;
        for(int [] stu : classes){
            res += (double)stu[0]/stu[1];
        }

        return res/classes.length;
    }
}
