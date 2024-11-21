import java.util.Arrays;

public class leetcode_28 {
    public static void main(String[] args) {
        String needle = "code";
        String hayStack = "leetcodeleetcode";
        StringBuilder sb = new StringBuilder(needle);
        StringBuilder sb1 = new StringBuilder(hayStack);
        if (sb1.toString().contains(sb)){
            System.out.println(sb1.indexOf(sb.toString()));
        }else{
            System.out.println(-1);
        }
    }
}
