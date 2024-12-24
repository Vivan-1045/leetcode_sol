public class leetcode_326 {
    public static void main(String[] args) {
        int n = 243;
        System.out.println(isPowerOf3(n));
    }
    public static boolean isPowerOf3(int n){
        double x = (double)n;
        double k = ((Math.log10(x))/(Math.log10(3.0)));
        return k==(int)k?true:false;

        //Gives TLE
//        while (n%3==0){
//            n/=3;
//        }
//        if (n==1) return true;
//        return false;
    }
}
