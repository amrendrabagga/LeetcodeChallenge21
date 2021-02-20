package february.week3;

public class Day6_RomanToInteger {
    public int romanToInt(String s) {
        int res = 0;
        int i = 0;
        while (i < s.length()) {
            int s1 = romanToInteger(s.charAt(i));
            if (i + 1 < s.length()) {
                int s2 = romanToInteger(s.charAt(i + 1));
                if (s1 >= s2) {
                    res += s1;
                }
                else {
                    res += s2 - s1;
                    i++;
                }
            }
            else {
                res += s1;
            }
            i++;
        }
        return res;
    }

    private int romanToInteger(char c) {
        if (c == 'I') {
            return 1;
        }
        if (c == 'V') {
            return 5;
        }
        if (c == 'X') {
            return 10;
        }
        if (c == 'L') {
            return 50;
        }
        if (c == 'C') {
            return 100;
        }
        if (c == 'D') {
            return 500;
        }
        if (c == 'M') {
            return 1000;
        }
        return -1;
    }

    public static void main(String[] args) {
        Day6_RomanToInteger obj = new Day6_RomanToInteger();
        System.out.println(obj.romanToInt("IX"));

    }
}
