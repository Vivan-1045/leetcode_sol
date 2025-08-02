package Contests;

public class biweekly_162 {
    public static void main(String[] args) {

    }
    public static int finishTime(int[] landS, int[] landD, int[] waterS, int[] waterD) {
        int minTime = Integer.MAX_VALUE;

        for (int i = 0; i < landS.length; i++) {
            for (int j = 0; j < waterS.length; j++) {
                int landFinish = landS[i] + landD[i];

                int waterFinish = Math.max(waterS[j], landFinish) + waterD[j];

                minTime = Math.min(minTime, waterFinish);

                int landFinish2 = Math.max(landS[i], waterS[j] + waterD[j]) + landD[i];

                minTime = Math.min(minTime, landFinish2);
            }
        }

        return minTime;
    }


}
