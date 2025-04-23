package Contests;

import java.util.HashSet;
import java.util.Set;

class weekly_446 {
    public long calculateScore(String[] instructions, int[] values) {
        return calCulate(instructions,values);
    }
    long calCulate(String[] instructions, int[] values) {
        long score = 0;
        int n = instructions.length;
        int i = 0;
        Set<Integer> visited = new HashSet<>();

        while (i >= 0 && i < n && !visited.contains(i)) {
            visited.add(i);
            if (instructions[i].equals("add")) {
                score += values[i];
                i++;
            } else if (instructions[i].equals("jump")) {
                i += values[i];
            }
        }

        return score;
    }
}