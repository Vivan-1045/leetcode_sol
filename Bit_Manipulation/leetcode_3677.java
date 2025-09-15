package Bit_Manipulation;

public class leetcode_3677 {
    public static void main(String[] args) {
        System.out.println(countBinary(9));
    }
    public static int countBinary(long n){

        int cnt = 0;
        for(int i = 1;i<=n;i++){
            if(isPalin(i)){
                cnt++;
            }
        }

        return cnt;
    }

    public static boolean isPalin(int n){
        if(n==0){
            return false;
        }
        String s = Integer.toBinaryString(n);

        String s1 = "";

        boolean one = false;
        for(char c : s.toCharArray()){
            if(c=='0' && !one){
                continue;
            }else{
                one = true;
                s1 += c;
            }
        }

        if(s1.length()==1){
            return true;
        }


        int j = s.length()-1;
        for(int i = 0;i<s.length()/2;i++){
            if(s.charAt(i)!=s.charAt(j--)){
                return false;
            }
        }

        return true;
    }
}
