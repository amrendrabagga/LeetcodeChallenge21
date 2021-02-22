package february.week4;

import java.util.Collections;
import java.util.List;

public class Day1_LongestWordInDictionaryThroughDeleting {
    public String findLongestWord(String s, List<String> d) {
        Collections.sort(d, (a, b) -> a.length() == b.length() ? a.compareTo(b) : b.length() - a.length());
        for (String word : d) {
            if (isSubsequence(s, word)) {
                return word;
            }
        }
        return "";
    }
    private boolean isSubsequence(String s, String word) {
        int j = 0;
        for (int i=0; i<s.length() && j<word.length(); i++) {
            if (s.charAt(i) == word.charAt(j)) {
                j++;
            }
        }
        return j >= word.length();
    }
}
