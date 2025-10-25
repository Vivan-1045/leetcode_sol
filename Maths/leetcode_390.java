package Maths;

import java.util.Collections;
import java.util.PriorityQueue;

public class leetcode_390 {
    public int lastRemaining(int n) {
        return lastRemainEle(n);
    }

    //Brute force
    int lastEle(int n){
        if(n==1){
            return 1;
        }
        if(n==3){
            return 2;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        PriorityQueue<Integer> pq1 = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 1;i<=n;i++){
            pq.add(i);
        }
        boolean leftToRight = true;
        while (pq.size() > 1 || pq1.size() > 1) {

            if (leftToRight) {
                int i = 0;
                while (!pq.isEmpty()) {
                    int val = pq.poll();
                    if (i % 2 != 0) pq1.add(val);
                    i++;
                }

                if (pq1.size() == 1) return pq1.poll();
                pq.clear();
            } else {
                int j = 0;
                while (!pq1.isEmpty()) {
                    int val = pq1.poll();
                    if (j % 2 != 0) pq.add(val);
                    j++;
                }

                if (pq.size() == 1) return pq.poll();
                pq1.clear();
            }

            leftToRight = !leftToRight;
        }
        return 0;

    }

    //Optimal approach
    int lastRemainEle(int n){
        int step = 1;
        int remainEle = n;
        int head = 1;
        boolean left = true;

        while(remainEle>1){
            if(left || remainEle %2==1){
                head+=step;
            }

            remainEle /= 2;
            step *=2;
            left = !left;
        }

        return head;
    }
}
