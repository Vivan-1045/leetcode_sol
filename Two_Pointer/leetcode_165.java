package Two_Pointer;
public class leetcode_165 {
    public static void main(String[] args) {
        String v1 = "1";
        String v2 = "1.0";
        System.out.println(compareVersion(v1,v2));
    }
    public static int compareVersion(String v1 , String v2){
        String[] s1 = v1.split("\\.");
        String[]s2 = v2.split("\\.");

        if (s1.length==s2.length){
            for (int i =0;i<s1.length;i++){
                if (Integer.parseInt(s1[i])>Integer.parseInt(s2[i])){
                    return 1;
                } else if (Integer.parseInt(s1[i])<Integer.parseInt(s2[i])) {
                    return -1;
                }
            }
        }else{
            return compare(s1,s2);
        }
         return 0;
    }
    public static int compare(String[] s1,String[]s2){
        int n=0,m=0;
        boolean v1 = false;
        boolean v2 = false;
        if (s1.length<s2.length){
            n=s1.length;
            m=s2.length;
            v2 = true;
        }else if (s1.length>s2.length){
            n= s2.length;
            m= s1.length;
            v1 = true;
        }


        for (int i =0;i<n;i++){
            if (Integer.parseInt(s1[i])>Integer.parseInt(s2[i])){
                return 1;
            } else if (Integer.parseInt(s1[i])<Integer.parseInt(s2[i])) {
                return -1;
            }
        }

        for (int i = n;i<m;i++){
            if (v2){
                if (Integer.parseInt(s2[i]) != 0){
                    return -1;
                }
            }
            if (v1){
                if (Integer.parseInt(s1[i])!=0){
                    return 1;
                }
            }
        }
        return 0;
    }
}
