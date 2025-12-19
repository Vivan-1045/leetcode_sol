package Greedy;

import java.util.*;

public class leetcode_2092 {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        return allPeople(n,meetings,firstPerson);
    }

    List<Integer> allPeople(int n , int [][] meets, int firstPerson){
        Set<Integer> st = new HashSet<>();
        st.add(0);
        st.add(firstPerson);

        Arrays.sort(meets , (a, b) -> a[2]-b[2]);

        int i = 0;
        while(i<meets.length){
            int p1 = meets[i][0];
            int p2 = meets[i][1];
            int t = meets[i][2];

            List<int[]> sameTimeMeet = new ArrayList<>();
            sameTimeMeet.add(new int[]{p1,p2});
            int j = i+1;
            while(j < meets.length && t==meets[j][2]){
                sameTimeMeet.add(new int[]{meets[j][0],meets[j][1]});
                j++;
            }

            boolean changed;
            do {
                changed = false;
                Iterator<int[]> it = sameTimeMeet.iterator();
                while (it.hasNext()) {
                    int[] a = it.next();
                    if (st.contains(a[0]) || st.contains(a[1])) {
                        st.add(a[0]);
                        st.add(a[1]);
                        it.remove();
                        changed = true;
                    }
                }
            } while (changed);
            i = j;
        }

        return new ArrayList<>(st);
    }
}
