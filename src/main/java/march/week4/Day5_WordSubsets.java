package march.week4;

import java.util.ArrayList;
import java.util.List;

public class Day5_WordSubsets {
    public List<String> wordSubsets(String[] A, String[] B) {
        // so we maintain maxFrequencyCount of every letter in B
        // say B has [e, oe, oooeee, ga]
        // maxFrequencyCount will look like [a -> 1, b -> 0 ... e ->3, g -> 1, o -> 3]
        // now for each work in A we check whether freq of each word is less than its maxfreq
        // if yes then include in list

        int maxFrequency[] = new int[26];
        List<String> result = new ArrayList();
        for (int i=0; i<B.length; i++) {
            int charFrequency[] = getCharacterFrequency(B[i]);
            for (int j=0; j<26; j++) {
                maxFrequency[j] = Math.max(maxFrequency[j], charFrequency[j]);
            }
        }

        for (int i=0; i<A.length; i++) {
            int currentWordFrequency[] = getCharacterFrequency(A[i]);
            boolean isWordValid = true;
            for (int j=0; j<26; j++) {
                if (maxFrequency[j] > currentWordFrequency[j]) {
                    isWordValid = false;
                    break;
                }
            }
            if (isWordValid) {
                result.add(A[i]);
            }
        }
        return result;
    }

    private int[] getCharacterFrequency(String s) {
        int count[] = new int[26];
        for (int j=0; j<s.length(); j++) {
            count[s.charAt(j) - 'a']++;
        }
        return count;
    }
}
