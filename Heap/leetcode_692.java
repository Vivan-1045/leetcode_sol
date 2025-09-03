package Heap;

import java.util.*;

public class leetcode_692 {
    static class Pair{
        String s;
        int count;
        Pair(String s, int count){
            this.s=s;
            this.count = count;
        }
    }

    public static void main(String[] args) {

    }

    public static List<String> topKElement(String[] words,int k){
        Arrays.sort(words);
        List<String> ans = new ArrayList<>();
        TreeMap<String,Integer> mp = new TreeMap<>();

        for(String s : words){
            mp.put(s,mp.getOrDefault(s,0)+1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
            if (b.count != a.count) {
                return Integer.compare(b.count, a.count);
            } else {
                return a.s.compareTo(b.s);
            }
        });
        for(Map.Entry<String,Integer> entry : mp.entrySet()){
            pq.offer(new Pair(entry.getKey(),entry.getValue()));
        }

        while(k-->0){
            ans.add(pq.poll().s);
        }

        int freq = mp.get(ans.get(0));
        int i = 0;
        for(String s : ans){
            if(mp.get(s) != freq && i != ans.size()){
                return ans;
            }
            i++;
        }

        Collections.sort(ans);
        return ans;
    }
}
