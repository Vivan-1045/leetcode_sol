package Easy;

import java.util.ArrayList;
import java.util.List;

public class leetcode_202 {
    public static void main(String[] args) {
        int n = 2;
        System.out.println(isPossible(n));
    }
    public static boolean isHappy(int n){
        List<Integer> list = new ArrayList<>();
        int m = findSqSum(n);
        while (m != 1){
            if (list.contains(m)){
                return false;
            }
            list.add(m);
            m = findSqSum(m);
        }
        return true;
    }


    //Another way
    public static boolean isPossible(int n){
        int s = n;
        int f = n;

        do {
            s = findSqSum(s);
            f = findSqSum(findSqSum(f));
        }while (s != f);

       return s==1;
    }

//    public static int findSqSum(int n){
//        if (n==0){
//            return 0;
//        }
//        return (n%10)*(n%10) + findSqSum(n/10);
//    }

    public static int findSqSum(int n){
        int ans = 0;
        while (n>0){
            ans += (n%10)*(n%10);
            n /=10;
        }
        return ans;
    }


}
