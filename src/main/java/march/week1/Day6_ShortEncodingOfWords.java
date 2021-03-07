package march.week1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Day6_ShortEncodingOfWords {
    public int minimumLengthEncoding(String[] words) {
        Set<String> set = new HashSet(Arrays.asList(words));
        for (String word : words) {
            for (int i=1; i<word.length(); i++) {
                // remove element from set which are substring other words
                // also notice we are indirectly removing words,
                // which are substring to other words and have less length
                set.remove(word.substring(i));
            }
        }
        int res = set.size();
        for (String word : set) {
            res += word.length();
        }
        System.out.println(set);
        return res;
    }
}
