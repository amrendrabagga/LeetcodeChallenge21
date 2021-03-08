package march.week2;

public class Day1_RemovePalindromicSubstring {
    public int removePalindromeSub(String s) {
        if (s.length() == 0) {
            return 0;
        }
        if (isPalindrome(s)) {
            return 1;
        }
        return 2;
    }

    private boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    public static void main(String[] args) {
        Day1_RemovePalindromicSubstring obj = new Day1_RemovePalindromicSubstring();
        System.out.println(obj.removePalindromeSub("baabb"));
    }
}
