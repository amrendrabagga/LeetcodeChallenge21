package may.week2;

import java.util.ArrayList;
import java.util.List;

public class Day1_SuperPalindromes {
    public int superpalindromesInRange(String left, String right) {
        Long l = Long.parseLong(left);
        Long r = Long.parseLong(right);

        int res = 0;
        List<Long> palindroms = new ArrayList();

        for (long i=1; i<=9; i++) {
            palindroms.add(i);
        }

        for (long i=1; i<10000; i++) {
            String leftPart = String.valueOf(i);
            StringBuilder rightPart = new StringBuilder(leftPart).reverse();
            palindroms.add(Long.parseLong(leftPart + rightPart));

            for (long j=0; j<10; j++) {
                palindroms.add(Long.parseLong(leftPart + j + rightPart));
            }
        }

        for (Long p : palindroms) {
            long num = p * p;
            if (num >= l && num <= r && isPalindrom(String.valueOf(num))) {
                res++;
            }
        }
        return res;
    }

    private boolean isPalindrom(String s) {
        int i = 0, j = s.length()-1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
