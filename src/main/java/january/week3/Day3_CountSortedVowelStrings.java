package january.week3;

import java.util.Arrays;

public class Day3_CountSortedVowelStrings {
    int count = 0;
    char vowels[] = {'a', 'e', 'i', 'o', 'u'};
    public int countVowelStrings(int n) {
        countVowelStringsUtils("", n);
        return count;
    }
    private void countVowelStringsUtils(String s, int n) {
        if (s.length() == n) {
            count++;
            return;
        }
        for (int i = 0; i<vowels.length; i++) {
            if (s.length() == 0 || vowels[i] >= s.charAt(s.length()-1)) {
                countVowelStringsUtils(s + vowels[i], n);
            }
        }
    }

    public int countVowelStringsEfficient(int n) {
        // a e i o u
        // 1 1 1 1 1 n = 1
        // 5 4 3 2 1 n = 2
        // 15 10 6 3 1 n = 2
        // oo o/u
        // ouu
        int res[] = new int[5];
        Arrays.fill(res, 1);
        for (int i=2; i<=n; i++) {
            for (int j=3; j>=0; j--) { // j = 4, ie for last vowel u, only 1 combination is present
                res[i] += res[i+1];
            }
        }
        int ans = 0;
        for (int num : res) {
            ans += num;
        }
        return ans;
    }
}
