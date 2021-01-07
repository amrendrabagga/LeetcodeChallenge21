package january.week1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Day7_LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        int res = 0;
        int i = 0;
        int j = 0;
        Set<Character> set = new HashSet<>();
        while (j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                j++;
                res = Math.max(res, set.size());
            }
            else {
                set.remove(s.charAt(i));
                i++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Day7_LongestSubstringWithoutRepeatingCharacters obj = new Day7_LongestSubstringWithoutRepeatingCharacters();
        System.out.println(obj.lengthOfLongestSubstring("dvdf"));
    }
}
