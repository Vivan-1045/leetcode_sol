package unCategorisedCode;

public class leetcode_2698 {
    public static void main(String[] args) {
        int n = 1000;
        System.out.println(punishmentNum(n));
    }
    public static int punishmentNum(int n){
        int ans = 0;
        int sq = 0;
        for (int i =1;i<=n;i++){
            sq =i*i;
            if (checkNumber(sq,i,0)){
                ans += sq;
            }
        }
        return ans;
    }


    public static boolean checkNumber(int sq, int n, int currSum){
        if (currSum>n){
            return false;
        }
        if (sq==0){
            return  currSum == n;
        }
        return checkNumber(sq/10,n,currSum+sq%10)||
                checkNumber(sq/100,n,currSum+sq%100)||
                checkNumber(sq/1000,n,currSum+sq%1000)||
                checkNumber(sq/10000,n,currSum+sq%10000);
    }


}
