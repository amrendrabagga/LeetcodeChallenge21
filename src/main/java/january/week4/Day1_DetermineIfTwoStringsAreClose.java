package january.week4;

import java.util.Arrays;

public class Day1_DetermineIfTwoStringsAreClose {
    public boolean closeStrings(String word1, String word2) {
        int f1[] = new int[26];// contains frequency of each character of word1
        int f2[] = new int[26];// contains frequency of each character of word2
        int v1[] = new int[26];// check presence of characters in word1
        int v2[] = new int[26];// check presence of characters in word2

        for (char c : word1.toCharArray()) {
            f1[c - 'a']++;
            v1[c - 'a'] = 1;
        }
        for (char c : word2.toCharArray()) {
            f2[c - 'a']++;
            v2[c - 'a'] = 1;
        }
        Arrays.sort(f1);
        Arrays.sort(f2);
        // here we check equality between sorted f1[] and f2[]
        // ie if they match irrespective of particular character frequency, then they can be tranformed
        // into respective target string
        // also check equality between v1[] and v2[] for characters presence
        // ex abc abz, ie if same characters are present or not
        return Arrays.equals(f1, f2) && Arrays.equals(v1, v2);
    }
}
