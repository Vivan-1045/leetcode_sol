import java.util.Arrays;

public class leetcode_557 {
    public static void main(String[] args) {
        String s = "Mr Ding";
        StringBuilder finalString = new StringBuilder();
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        String s3 = sb.toString();
        String[] st2 = s3.split(" ");
        for (int i = st2.length-1;i>=0;i--){
            finalString.append(i==0?st2[i] :st2[i]+" ");
        }
        String fd1 = finalString.toString();
        System.out.println(fd1);
    }
}
