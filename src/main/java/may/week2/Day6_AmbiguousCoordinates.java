package may.week2;

import java.util.ArrayList;
import java.util.List;

public class Day6_AmbiguousCoordinates {
    // digits not allowed
    // 01, 01.2, 1.20, 1.0
    List<String> result = new ArrayList();
    public List<String> ambiguousCoordinates(String s) {
        s = s.substring(1, s.length()-1);
        for (int i=1; i<s.length(); i++) {
            helper(s.substring(0, i), s.substring(i));
        }

        return result;
    }

    private void helper(String x, String y) {
        List<String> dotx = putDot(x);
        List<String> doty = putDot(y);
        for (String dx : dotx) {
            if (isValid(dx)) {
                for (String dy : doty) {
                    if (isValid(dy)) {
                        result.add("(" + dx + ", " + dy + ")");// (1, 23)
                    }
                }
            }
        }
    }

    private List<String> putDot(String s) {
        List<String> res = new ArrayList();
        res.add(s);
        for (int i=1; i<s.length(); i++) {
            res.add(s.substring(0, i) + "." + s.substring(i));
        }
        return res;
    }

    private boolean isValid(String s) {
        if (s.contains(".")) {
            String[] part = s.split("\\.");
            // 0.1(correct) 01(incorrect)
            if (!part[0].equals("0") && part[0].startsWith("0")) return false;
            // 1.20(incorrect)
            else return !part[1].endsWith("0");
        }
        else {
            if (s.equals("0")) return true;
            else return !s.startsWith("0");
        }
    }

    public static void main(String[] args) {
        Day6_AmbiguousCoordinates obj = new Day6_AmbiguousCoordinates();
        System.out.println(obj.ambiguousCoordinates("(0123)"));
    }
}
