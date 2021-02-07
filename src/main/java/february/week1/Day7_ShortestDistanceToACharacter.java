package february.week1;

import java.util.Arrays;
import java.util.TreeSet;

public class Day7_ShortestDistanceToACharacter {
    public int[] shortestToChar(String s, char c) {
        TreeSet<Integer> set = new TreeSet();
        int n = s.length();
        for (int i=0; i<n; i++) {
            if (s.charAt(i) == c) {
                set.add(i);
            }
        }
        int res[] = new int[n];
        for (int i=0; i<n; i++) {
            Integer floor = set.floor(i);
            Integer ceil = set.ceiling(i);
            int r = Integer.MAX_VALUE;
            if (floor != null && ceil != null) {
                r = Math.min(i - floor, ceil - i);
            }
            else if (floor != null) {
                r = Math.min(r, i - floor);
            }
            else {
                r = Math.min(r, ceil - i);
            }
            res[i] = r;
        }
        return res;
    }

    public static void main(String[] args) {
        Day7_ShortestDistanceToACharacter obj = new Day7_ShortestDistanceToACharacter();
        System.out.println(Arrays.toString(obj.shortestToChar("loveleetcode", 'e')));

    }
}
