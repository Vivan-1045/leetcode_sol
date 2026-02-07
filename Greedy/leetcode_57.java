package Greedy;

public class leetcode_57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        return insertInt(intervals,newInterval);
    }
    int[][] insertInt(int[][] arr,int[]a){

        int n = arr.length;

        int[][]res = new int[n+1][2];
        int x = 0;
        int i = 0;


        int s = a[0];
        int e = a[1];

        //Add starting intervals
        while(i<n && arr[i][1]<s){
            res[x++] = arr[i++];
        }

        //Merging all overlapping index
        while(i<n && arr[i][0]<=e){
            s = Math.min(s,arr[i][0]);
            e = Math.max(e,arr[i][1]);
            i++;
        }

        //Add newIntervals
        res[x++] = new int[]{s,e};

        //Add remainig interval
        while(i<n){
            res[x++] = arr[i++];
        }

        int [][]ans = new int[x][2];
        for(int j = 0;j<x;j++){
            ans[j] = res[j];
        }

        return ans;
    }
}
