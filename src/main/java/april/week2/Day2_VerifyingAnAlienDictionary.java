package april.week2;

public class Day2_VerifyingAnAlienDictionary {
    int[] chars;
    public boolean isAlienSorted(String[] words, String order) {
        chars = new int[26];
        for (int i=0; i<order.length(); i++) {
            chars[order.charAt(i) - 'a'] = i;
        }

        for (int i=1; i<words.length; i++) {
            if (compare(words[i - 1], words[i]) > 0) {
                // if any char in word1 comes after word2 then false
                return false;
            }
        }
        return true;
    }

    private int compare(String word1, String word2) {
        int i = 0, j = 0;
        int charComparison = 0;
        while (i < word1.length() && j < word2.length() && charComparison == 0) {
            charComparison = chars[word1.charAt(i) - 'a'] - chars[word2.charAt(j) - 'a'];
            i++;
            j++;
        }
        // if either of word length is smaller and till now comparison is equal
        // then word1 length should be smaller than word2, for correct sorting order
        if (charComparison == 0) {
            return word1.length() - word2.length();
        }
        return charComparison;
    }
}
