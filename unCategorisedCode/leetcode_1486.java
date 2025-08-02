package unCategorisedCode;

public class leetcode_1486 {
    public static void main(String[] args) {
        System.out.println(Xor(5, 0));
    }
    public static int Xor(int n,int s){
        int Xor = 0;
        int i = 0;
        for(i = 0;i<n;i++){
            Xor ^= (s+2*i);
        }
        return Xor;
    }
}
