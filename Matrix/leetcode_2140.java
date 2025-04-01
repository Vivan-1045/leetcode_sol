package Matrix;

public class leetcode_2140 {
    public static void main(String[] args) {
        int [][] arr = {{1,1},{2,2},{3,3},{4,4},{5,5}};
        System.out.println(maxMark(arr));
    }
    public static long maxMark(int[][] question){
        int n = question.length;
        long []memo = new long[n];
        return getMark(question,0,memo);
    }
    public static long getMark(int[][] question,int s,long []memo){
        if (s>= question.length){
            return 0;
        }

        if(memo[s] !=0){
            return memo[s];
        }

        long skip = getMark(question,s+1,memo);
        long solve = question[s][0] +getMark(question,s+question[s][1]+1,memo);

        return memo[s] = Math.max(skip,solve);
    }
}
