package Maths;

public class leetcode_1513 {
    public int numSub(String s) {
        return num(s);
    }

    int num(String s){
        int MOD = 1000000007;
        int n = s.length();
        long oneCnt = 0;
        long res = 0;

        for(char ch : s.toCharArray()){
            int  val = ch-'0';
            if(val==1){
                oneCnt++;
            }else{
                res = (res + (oneCnt * (oneCnt + 1) % MOD) * ((MOD + 1) / 2) % MOD) % MOD;
                oneCnt = 0;
            }
        }

        if(oneCnt !=0){
            res = (res + (oneCnt * (oneCnt + 1) % MOD) * ((MOD + 1) / 2) % MOD) % MOD;
        }

        return (int)res;
    }
}
