package Binary_Search;

import java.util.ArrayList;
import java.util.List;

public class leetcode_2040 {
    public static void main(String[] args) {
        int[]arr = {-100000,100000};
        int[]arr1= {-100000,100000};
        System.out.println(kthPro(arr,arr1,1));
    }

    //Simulation
    public static long kthProduct(int[] arr1,int[] arr2,long k){
        List<Long> list = new ArrayList<>();
        for (int value : arr1) {
            for (int i : arr2) {
                list.add(((long) value * i));
            }
        }
        list.sort(null);
        return list.get((int) (k-1));
    }

    //Using Binary Search
    public static long kthPro(int[] arr1,int []arr2,long k){
        long l = (long) -1e10;
        long r = (long) 1e10;

        long res = 0;

        while (l<=r){
          long mid = l + (r-l)/2;
          long count = countEqualOrLess(arr1,arr2,mid);

          if (count>=k){
              res = mid;
              r= mid-1;
          }else{
              l = mid+1;
          }

        }
        return res;
    }

    public static long countEqualOrLess(int[]arr1,int[]arr2,long midPro){
        long cnt  = 0;
        int n = arr2.length;

        for (int num : arr1){
            if (num>=0){
                int l = 0,r = n-1,pos = -1;
                while (l<=r){
                    int mid = l +(r-l)/2;
                    long prod = (long) num * arr2[mid];

                    if (prod<=midPro){
                        pos = mid;
                        l = mid+1;
                    }else{
                        r = mid-1;
                    }
                }

                cnt  += (pos+1);
            }else{
                int l = 0,r = n-1,pos = n;
                while (l<=r){
                    int mid = l +(r-l)/2;
                    long prod = (long) num * arr2[mid];

                    if (prod<=midPro){
                        pos = mid;
                        r = mid-1;
                    }else{
                        l = mid+1;
                    }
                }

                cnt  += (n-pos);
            }
        }
        return cnt;
    }

}
