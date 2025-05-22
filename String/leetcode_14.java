package String;

public class leetcode_14 {
    public static void main(String[] args) {
        String str[] = {""};
        System.out.println(Prefix(str));
    }
    public static String Prefix(String str[]){
        String pre = str[0];
        if (str.length==0){
            return "";
        }
        for (int i = 1; i< str.length;i++){
            while (str[i].indexOf(pre)!=0){
                if (pre.length()==0){
                    return "";
                }
                pre = pre.substring(0,pre.length()-1);
            }
        }
        return pre;
    }
}
