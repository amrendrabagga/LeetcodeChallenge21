package may.week3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Day3_LongestStringChain {
    // Time Complexity O(NlogN + N * L * L)
    public int longestStrChain(String[] words) {
        // O(NlogN)
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        // map stores word and chain length
        Map<String, Integer> map = new HashMap();
        int res = 0;
        // O(N * L * L)
        for (String word : words) {
            map.put(word, 1);
            // O(L * L)
            for (int i=0; i<word.length(); i++) {
                StringBuilder current = new StringBuilder(word);
                // O(L)
                String next = current.deleteCharAt(i).toString();
                if (map.containsKey(next)) {
                    map.put(word, Math.max(map.get(word), map.get(next) + 1));
                }
            }
            res = Math.max(res, map.get(word));
        }
        return res;
    }
}
