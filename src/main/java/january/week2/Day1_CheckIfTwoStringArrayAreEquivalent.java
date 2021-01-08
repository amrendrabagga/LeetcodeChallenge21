package january.week2;

import java.util.stream.Stream;

public class Day1_CheckIfTwoStringArrayAreEquivalent {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        String w1 = Stream.of(word1).reduce("", (a, b) -> a + b);
        String w2 = Stream.of(word2).reduce("", (a, b) -> a + b);
        return w1.equals(w2);
    }
}
