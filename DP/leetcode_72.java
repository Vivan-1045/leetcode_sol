package DP;

public class leetcode_72 {
    static int m,n;
    static int[][] dp = new int[501][501];
    public static void main(String[] args) {
        String s1 = "intention";
        String s2 = "execution";
        m = s1.length();
        n = s2.length();
        System.out.println(minOpr(s1,s2,0,0));
    }
    public static int minOpr(String s1, String s2, int i,int j){
        if (i==m){
            return n-j; //Insert the character in s1
        } else if (j==n) {
            return m-i; //Delete character from s1
        }
        if (dp[i][j] != 0){
            return dp[i][j];
        }

        if (s1.charAt(i)==s2.charAt(j)){
            return minOpr(s1,s2,i+1,j+1);
        }else {

            int del = 1 + minOpr(s1, s2, i + 1, j); //Delete current character and check for next one
            int rep = 1 + minOpr(s1, s2, i + 1, j + 1); //Replace the current character, so that both are equal move both pointer
            int ins = 1 + minOpr(s1, s2, i, j + 1); //Insert the new character nad move the jth pointer
            return dp[i][j] = Math.min(del, Math.min(ins, rep));
        }
    }
}
