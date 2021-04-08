package april.week2;

import java.util.ArrayList;
import java.util.List;

public class Day1_LetterCombinationOfPhoneNumber {
    private String[] letters = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    private StringBuilder sb = new StringBuilder();

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() == 0) {
            return result;
        }

        letterCombinationsUtils(digits, 0, result);
        return result;
    }
    private void letterCombinationsUtils(String digits, int index, List<String> result) {
        if (index == digits.length()) {
            result.add(sb.toString());
            return;
        }

        String letter = letters[digits.charAt(index) - '2'];
        for (int i=0; i<letter.length(); i++) {
            sb.append(letter.charAt(i));
            letterCombinationsUtils(digits, index + 1, result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        Day1_LetterCombinationOfPhoneNumber obj = new Day1_LetterCombinationOfPhoneNumber();
        System.out.println(obj.letterCombinations("23"));
    }
}
