package february.week2;

import java.util.Arrays;

public class Day4_ValidAnagram {
    public boolean isAnagram(String s, String t) {
        char cs[] = new char[26];
        char ts[] = new char[26];
        for (char c : s.toCharArray()) {
            cs[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            ts[c - 'a']++;
        }
        return Arrays.equals(cs, ts);
    }
}
