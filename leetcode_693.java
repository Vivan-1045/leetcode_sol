public class leetcode_693 {
    public static void main(String[] args) {
        System.out.println(Boolvalue(2));
    }
    public static boolean Boolvalue(int n){

        int firstBit = n&1;
        n = n>>1;
        while (n>0){
            int currentBit = n&1;
            if (currentBit == firstBit){
                return false;
            }
            firstBit = currentBit;
            n = n>>1;
        }
        return true;
    }
}
