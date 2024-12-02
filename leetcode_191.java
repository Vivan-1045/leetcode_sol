public class leetcode_191 {
    public static void main(String[] args) {
        int n = 2147483645;
        System.out.println(SetBits(n));
    }
    public static int SetBits(int n){
        int count =0;
        while (n>0){
            if ((n&1)==1){
                count++;
            }
            n = n>>1;
        }
        return count;
    }

}
