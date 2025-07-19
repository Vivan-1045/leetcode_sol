package String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class leetcode_1233 {
    public static void main(String[] args) {
        String[] folder = {"/ah/al/am","/ah/al"};
        System.out.println(solve(folder));
    }
    public static List<String> removeSubFolder(String [] folder){
        List<String> ans = new ArrayList<>();
        Arrays.sort(folder);
        boolean []isSubFolder = new boolean[folder.length+1];
        for(int i = 0;i< folder.length;i++){
            if(isSubFolder[i]==true){
                continue;
            }
            String s = folder[i];
            String[] sr = s.split("/");
            for (int j =i+1;j< folder.length;j++){
                String s1 = folder[j];
                String[] sr1 = s1.split("/");
                if (subFolder(sr,sr1)){
                    isSubFolder[j]=true;
                }
            }
        }
        for (int i = 0;i<folder.length;i++){
            if (!isSubFolder[i]){
                ans.add(folder[i]);
            }
        }
        return ans;
    }

    public static boolean subFolder(String []s1,String[]s2){
        if (s1.length> s2.length){
            return false;
        }
        for (int i =0;i< s1.length;i++){
            if (!Objects.equals(s1[i], s2[i])){
                return false;
            }
        }
        return true;
    }

    public static List<String> solve(String[] folder){
        List<String> ans = new ArrayList<>();
        Arrays.sort(folder);
        String last = "";
        for (String s : folder) {
            if (last.isEmpty() ||!s.startsWith(last + "/")) {
                ans.add(s);
                last = s;
            }
        }
        return ans;
    }
}
