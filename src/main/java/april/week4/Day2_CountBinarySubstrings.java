package april.week4;

public class Day2_CountBinarySubstrings {
    public int countBinarySubstrings(String s) {
        int grouped[] = new int[s.length()];
        int idx = 0;
        grouped[0] = 1;
        for (int i=1; i<s.length(); i++) {
            if (s.charAt(i) != s.charAt(i-1)) {
                idx++;
                grouped[idx] = 1;
            }
            else {
                grouped[idx]++;
            }
        }
        int res = 0;
        for (int i=1; i<grouped.length; i++) {
            res += Math.min(grouped[i-1], grouped[i]);
        }
        return res;
    }
}
