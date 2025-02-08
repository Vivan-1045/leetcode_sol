import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class leetcode_2349 {
    Map<Integer,Integer> mpIdx = new HashMap<>();
    Map<Integer, PriorityQueue<Integer>> mpNum = new HashMap<>();

    void change(int idx , int number){
        mpIdx.put(idx,number);
        mpNum.putIfAbsent(number,new PriorityQueue<>());
        mpNum.get(number).offer(idx);

    }

    int find(int number){
        if (!mpNum.containsKey(number)){
            return -1;
        }

        PriorityQueue<Integer> priorityQueue = mpNum.get(number);
        while (!priorityQueue.isEmpty()){
            int preIdx = priorityQueue.peek();
            if (mpIdx.get(preIdx)==number) {
                return preIdx;
            }
            priorityQueue.poll();
        }
        return -1;

    }
}
