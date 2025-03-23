package Contests;

public class weekly_442 {
    public static void main(String[] args) {
        int n = 2;
        int w = 3;
        int mW = 15;
        System.out.println(maxWeight(n,w,mW));
    }
    public static int maxWeight(int n , int w, int mW){
        return Math.min(n*n,mW/w);
    }

}
