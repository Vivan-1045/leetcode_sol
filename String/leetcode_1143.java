package String;

public class leetcode_1143 {
    public static void main(String[] args) {

    }
    public static int solve(String s1, String s2,int idx1,int idx2, int max1){
        if (idx1>=s1.length()&&idx2>s2.length()){
            return 0;
        }
        if (s1.charAt(idx1)==s2.charAt(idx2)){
            int max = 1+ solve(s1,s2,idx1+1,idx2+1,max1);
            return Math.max(max1,max);

        }
        return 0; // here
    }
}
