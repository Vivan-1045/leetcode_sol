package String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class leetcode_763 {
    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
//        System.out.println(partitionLable(s));
        System.out.println(res(s));
    }
    public static List<Integer> partitionLable(String s){
        List<Integer> list = new ArrayList<>();
        int n = s.length();

        int [] lastIdx = new int[26];

        for (int i =0;i<n;i++){
            int idx = s.charAt(i)-'a';
            lastIdx[idx] = i;
        }

        int i =0;
        while (i<n){
            int last = lastIdx[s.charAt(i)-'a'];
            int j=i;
            while (j<last){
                last = Math.max(last,lastIdx[s.charAt(j)-'a']);
                j++;
            }

            list.add(j-i+1);
            i = j+1;
        }
        return list;
    }

    //Using hashTable
    public static List<Integer> res(String s){
        List<Integer> list = new ArrayList<>();
        Map<Character,Integer> mp = new HashMap<>();
        for (int i = 0;i<s.length();i++){
            int oc = 0;
            if (!mp.isEmpty()){
                if (mp.containsKey(s.charAt(i))){
                    oc = mp.get(s.charAt(i));

                }
            }
            mp.put(s.charAt(i),Math.max(i,oc));
        }

        int maxidx = mp.get(s.charAt(0));
        int j = 0;
        for (int i = 0;i<s.length();i++){


            maxidx = Math.max(maxidx,mp.get(s.charAt(i)));

            if (i==maxidx){

                list.add(maxidx+1-j);
                j = maxidx+1;
            }
        }

        return list;

    }
}
