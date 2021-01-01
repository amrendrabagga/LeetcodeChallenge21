package january.week1;

import java.util.HashMap;
import java.util.Map;

public class Day1_CheckArrayFormationThroughConcatenation {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        Map<Integer, Integer> map = new HashMap();
        for (int i=0; i<arr.length; i++) {
            map.put(arr[i], i);
        }
        for (int[] piece : pieces) {
            if (piece.length == 1 && !map.containsKey(piece[0])) {
                return false;
            }
            if (!map.containsKey(piece[0])) return false;
            int prev = map.get(piece[0]);
            for (int i=1; i<piece.length; i++) {
                if (!map.containsKey(piece[i])) return false;
                if (prev + 1 != map.get(piece[i])) return false;
                prev = map.get(piece[i]);
            }
        }
        return true;
    }

    public boolean canFormArrayEfficient(int[] arr, int[][] pieces) {
        int map[] = new int[101];
        for (int i=0; i<arr.length; i++) {
            map[arr[i]] = i+1;
        }

        for (int []piece : pieces) {
            if (map[piece[0]] == 0) return false;
            for (int i=1; i<piece.length; i++) {
                if (map[piece[i]] - map[piece[i-1]] != 1) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Day1_CheckArrayFormationThroughConcatenation obj = new Day1_CheckArrayFormationThroughConcatenation();
//        System.out.println(obj.canFormArray(new int[]{91,4,64,78}, new int[][]{{78},{4,64},{91}}));
        System.out.println(obj.canFormArray(new int[]{1,2,3}, new int[][]{{2},{1,3}}));
    }
}
