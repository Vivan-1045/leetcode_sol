package Maths;

public class leetcode_1780 {
    public static void main(String[] args) {
        int n = 12;
        System.out.println(isPowerThree(n));
    }
    public static boolean isPowerThree(int n){
        String base3 = Integer.toString(n,3);
        return !base3.contains("2");
    }
}
