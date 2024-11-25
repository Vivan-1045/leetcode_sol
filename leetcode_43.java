import java.math.BigInteger;
public class leetcode_43 {
    public static void main(String[] args) {
        String a = "498828660196";
        String b = "840477629533";
        System.out.println(Product(a,b));
    }
    public static String Product(String num1,String num2){
        BigInteger p = new BigInteger(num1);
        BigInteger q = new BigInteger(num2);
        StringBuilder sb = new StringBuilder();
        BigInteger product = p.multiply(q);
        sb.append(product);
        String pro = sb.toString();
        return pro;
    }

}

