import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
public class leetcode_3160 {
    public static void main(String[] args) {
      int [][] arr = {{1,4},{2,5},{1,3},{3,4}};
        System.out.println(Arrays.toString(resultArray(arr)));
    }
    public static int[] resultArray(int [][] query){
        //store the ball with their correspondence color
        Map<Integer,Integer> mpBall = new HashMap<>();

        //Store the count of each color from query
        Map<Integer,Integer> mpColor = new HashMap<>();

        int []res = new int[query.length];

        for (int i = 0; i<query.length;i++){
            int ball = query[i][0];  //ball
            int color = query[i][1]; //color

            //if ball already present in mpBall it means it already colored
            if (mpBall.containsKey(ball)){

                //get the previous color of ball
                int preColor = mpBall.get(ball);

                //decrease the count of that previous color in mpColor by exactly 1
                mpColor.put(preColor,mpColor.get(preColor)-1);

                //After decreasing the count if that entry in map become empty
                // then remove it from map to get exact size of map
                if (mpColor.get(preColor)==0){
                    mpColor.remove(preColor);
                }
            }

            //otherwise directly put the ball and color on the map
            mpBall.put(ball,color);

            //increase the count of that particular color by 1
            mpColor.put(color,mpColor.getOrDefault(color,0)+1);

            //store the size of map color in the res that will be our answer
            res[i] = mpColor.size();

        }
        return res;
    }
}
