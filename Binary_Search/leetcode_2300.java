package Binary_Search;

public class leetcode_2300 {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        return succcesFul(spells,potions,success);
    }

    int[] succcesFul(int[] sp,int[]pos,long s){
        int n = sp.length;
        int[] arr = new int[n];

        Arrays.sort(pos);
        int i = 0;
        for(int ele : sp){
            arr[i++] = totalPotion(pos,s,ele);
        }

        return arr;
    }

    int totalPotion(int[] pos,long s,int tar){
        int l =0;
        int r = pos.length-1;
        int cnt =0;

        while(l<=r){
            int m = l + (r-l)/2;
            if((long)tar*pos[m]>= s){
                cnt += r-m+1;
                r = m-1;
            }else if((long)tar*pos[m] < s){
                l = m+1;
            }
        }
        return cnt;
    }
}
