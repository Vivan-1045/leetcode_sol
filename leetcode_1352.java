import java.util.ArrayList;
import java.util.List;

public class leetcode_1352 {
    private List<Integer> arrList = new ArrayList<>();
    private static int n;
    public static void ProductOfNumbers() {
        n = 0;
    }

    public void add(int num) {
        if(num==0){
            arrList.clear();
            n =0;
        }else{
            if(arrList.isEmpty()){
                arrList.add(num);
            }else{
                arrList.add(arrList.get(n-1)*num);
            }
            n++;
        }


    }

    public int getProduct(int k) {
        if(k>n){
            return 0;

        }else if(k==n){
            return arrList.get(n-1);
        }
        return arrList.get(n-1)/arrList.get(n-k-1);
    }
}
