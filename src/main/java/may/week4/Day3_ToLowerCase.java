package may.week4;

public class Day3_ToLowerCase {
    public String toLowerCase(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (isUpper(c)) {
                sb.append(toLower(c));
            }
            else {
                sb.append(c);
            }

        }
        return sb.toString();
    }

    private boolean isUpper(int c) {
        return c >= 65 && c <= 90;
    }

    private char toLower(int c) {
        return (char)(c + 32);
    }

    public static void main(String[] args) {
        Day3_ToLowerCase obj = new Day3_ToLowerCase();
        System.out.println(obj.toLowerCase("He&LLo"));
    }
}
