package january.week4;

public class Day7_SmallestStringWithAGivenNumbericValue {
    public String getSmallestString(int n, int k) {
        char c[] = new char[n];
        for (int i = n; i >= 1; i--) {
            for (int j = 26; j >= 1; j--) {
                if (k - j >= i - 1) {
                    c[i - 1] = (char) (97 + j - 1);
                    k -= j;
                    break;
                }
            }
        }
        return String.valueOf(c);
    }
}
