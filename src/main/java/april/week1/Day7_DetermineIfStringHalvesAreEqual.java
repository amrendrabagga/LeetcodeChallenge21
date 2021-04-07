package april.week1;

public class Day7_DetermineIfStringHalvesAreEqual {
    public boolean halvesAreAlike(String s) {
        String s1 = s.substring(0, s.length()/2);
        String s2 = s.substring(s1.length());

        return s1.chars().filter(this::isVowel).count() == s2.chars().filter(this::isVowel).count();
    }

    private boolean isVowel(int c) {
        if (c > 96) {
            c -= 32;
        }
        return c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }

    public static void main(String[] args) {
        Day7_DetermineIfStringHalvesAreEqual obj = new Day7_DetermineIfStringHalvesAreEqual();
        System.out.println(obj.halvesAreAlike("Uaec"));
    }
}
