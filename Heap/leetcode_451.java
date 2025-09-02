package Heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class leetcode_451 {
    static class Pair{
        char ch;
        int count;

        Pair(char ch, int cnt){
            this.ch = ch;
            this.count = cnt;
        }
    }

    public static void main(String[] args) {

    }

    public static String sortedString(String s){
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b)-> Integer.compare(b.count,a.count));

        Map<Character,Integer> mp = new HashMap<>();

        for(char ch : s.toCharArray()){
            mp.put(ch,mp.getOrDefault(ch,0)+1);
        }

        for(Map.Entry<Character,Integer> entry: mp.entrySet()){
            pq.offer(new Pair(entry.getKey(),entry.getValue()));
        }

        String ans = "";
        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            int freqCnt = curr.count;
            char ch = curr.ch;

            while(freqCnt-->0){
                ans += ch;
            }
        }

        return ans;
    }
}
