package BinarySearch;

public class leetcode_2594 {
    public static void main(String[] args) {
        int []rank = {4,2,3,1};
        int car = 10;
        System.out.println(minTime(rank,car));
    }
    public static long minTime(int[] arr, int car) {
        long l = 1, r = (long) car * car * arr[0];

        while (l <= r) {
            long mid = l + (r - l) / 2;

            if (isPossible(arr, car, mid)) {
                r = mid;
            } else {
                l = (int) (mid + 1);
            }
        }
        return l;
    }

    public static boolean isPossible(int[] rank, int car, long mid) {
        long fixedCar = 0;

        for (int r : rank) {
            fixedCar += Math.sqrt(mid / r);
        }

        return fixedCar >= car;
    }
}
