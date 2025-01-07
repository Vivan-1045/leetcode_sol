import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode_1408 {
    public static void main(String[] args) {
        String[] st = {"leetcode","et","code"};
        System.out.println(subStrings(st));
    }
    public static List<String> subStrings(String[] st){
        List<String> list = new ArrayList<>();
        for (int a=0;a<st.length;a++){
            for (int i = 0;i<st.length;i++){
                if (a!=i && st[i].indexOf(st[a])!=-1){
                        list.add(st[a]);
                        break;
                }
            }
        }
        return list;
    }
}
