package Greedy;

import java.util.*;

public class leetcode_1733 {
    public static void main(String[] args) {

    }
    public static int minTech(int n , int [][] langs,int [][] friends){
        Map<Integer, List<Integer>> mp1 = new HashMap<>();

        int i = 1;
        for(int [] l : langs){
            List<Integer> list = new ArrayList<>();
            for(int ele : l){
                list.add(ele);
            }
            mp1.put(i++,list);
        }

        Set<Integer> st = new HashSet<>();

        for(int [] fr : friends){

            boolean sameL = false;
            for(int ele : mp1.get(fr[0])){
                if(mp1.get(fr[1]).contains(ele)){
                    sameL = true;
                    break;
                }
            }

            if(!sameL){
                st.add(fr[1]);
                st.add(fr[0]);
            }
        }

        if(st.isEmpty()){
            return 0;
        }

        Map<Integer, Integer> mp = new HashMap<>();
        for(int l : st){
            for(int ele : mp1.get(l)){
                mp.put(ele,mp.getOrDefault(ele,0)+1);
            }
        }

        int maxFreq = Integer.MIN_VALUE;
        for(int l : mp.values()){
            maxFreq = Math.max(maxFreq,l);
        }


        return st.size()-maxFreq;
    }
}
