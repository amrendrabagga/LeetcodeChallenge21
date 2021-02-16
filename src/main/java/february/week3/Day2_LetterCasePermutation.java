package february.week3;

import java.util.ArrayList;
import java.util.List;

public class Day2_LetterCasePermutation {
    public List<String> letterCasePermutation(String S) {
        List<String> res = new ArrayList();
        letterCasePermutationUtils(res, S.toCharArray(), 0);
        return res;
    }
    private void letterCasePermutationUtils(List<String> list, char []s, int index) {
        if (index == s.length) {
            list.add(new String(s));
            return;
        }
        if (Character.isDigit(s[index])) {
            letterCasePermutationUtils(list, s, index + 1);
        }
        else {
            s[index] = Character.toLowerCase(s[index]);
            letterCasePermutationUtils(list, s, index + 1);

            s[index] = Character.toUpperCase(s[index]);
            letterCasePermutationUtils(list, s, index + 1);
        }
    }
}
