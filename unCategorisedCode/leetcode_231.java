package unCategorisedCode;

public class leetcode_231{
    public static void main(String[] args){
        int n = 16;
        if(n==0&&n<0){
//            return false;
        }
//        return isPower(n);
    }
    public static boolean isPower(int n){
        if((n&(n-1))==0){
            return true;
        }
        return false;
    }
}