package CodeForces;

import java.util.Scanner;

//https://codeforces.com/problemset/problem/2137/C
public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            long a = sc.nextLong();
            long b = sc.nextLong();
            System.out.println(maxEven(a,b));
        }
    }

    public static long maxEven(long a, long b){
        long ans = -1;
        if((a%2)==0 && (b%2)==0){
            ans = a*(b/2) + 2;
        }else if((a%2)!=0 && (b%2)!=0){
            ans = a*b + 1;
        }
        else if((a%2)==0 && (b%2)!=0){
            return -1;
        }else{
            ans = a*(b/2)+(b/(b/2));
            if(ans%2!=0){
                return -1;
            }
        }
        return ans;
    }
}
