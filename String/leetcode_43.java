package String;

public class leetcode_43 {
    public static void main(String[] args) {
        String a = "8";
        String b = "0";
        System.out.println(Product(a,b));
    }
    public static String Product(String num1,String num2){
        int n = num1.length();
        int m = num2.length();
        if (n==0||m==0||num1.equals("0")||num2.equals("0")){
            return "0";
        }
        int[] ans = new int[m+n+1];
        for(int i = n-1;i>=0;i--){
            for(int j = m-1;j>=0;j--){
                int mul = (num1.charAt(i)-'0') * (num2.charAt(j)-'0');
                int sum = mul+ans[i+j+1];
                ans[i+j+1] = sum%10;
                ans[i+j] += sum/10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<ans.length-1;i++){
            if (!(sb.length()==0 && ans[i]==0)) {
                sb.append(ans[i]);
            }
        }
        String pro = sb.toString();
        return pro;
    }

}

