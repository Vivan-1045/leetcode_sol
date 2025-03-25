package Array;

import java.util.Arrays;
import java.util.Comparator;

public class leetcode_3169 {
    public static void main(String[] args) {
        int days = 10;
        int [][] meetings = {{5,7},{1,3},{9,10}};
        System.out.println(meetingDays(days,meetings));
    }
    public static int meetingDays(int days,int[][] meetings){
        int n = meetings.length;
        //Sort the 2d array using comparator
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));
        int []temp = new int[2];
        if(n==1){
            return days - (meetings[0][1]-meetings[0][0]+1);
        }
        temp[0] = meetings[0][0];
        temp[1] = meetings[0][1];
        int totalMeetingDays = 0;
        for (int i = 1;i<n;i++){

            int meetStart = meetings[i][0];
            int meetEnd = meetings[i][1];

            //if the arrays interval are overlapped
            if (temp[1]>= meetStart){
                temp[1] = Math.max(temp[1],meetEnd);
            }else{
                totalMeetingDays += temp[1]-temp[0]+1;
                temp[1]=meetEnd;
                temp[0] = meetStart;
            }

        }
        totalMeetingDays += temp[1]-temp[0]+1;

        return days-totalMeetingDays;
    }
}
