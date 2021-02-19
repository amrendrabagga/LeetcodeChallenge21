package february.week3;


public class Day5_MinimumRemoveToMakeValidParenthesis {
    public String minRemoveToMakeValid(String s) {
        char []ch = s.toCharArray();

        // for every ) there must exist (, prior to it
        int count = 0;
        for (int i=0; i<ch.length; i++) {
            if (ch[i] == '(') {
                count++;
            }
            else if (ch[i] == ')') {
                if (count > 0) {// balanced exist
                    count--;
                }
                else {
                    ch[i] = 0;
                }
            }
        }

        // for every ( there must exist ), prior to it
        count = 0;
        for (int i=ch.length - 1; i>=0; i--) {
            if (ch[i] == ')') {
                count++;
            }
            else if (ch[i] == '(') {
                if (count > 0) {// balanced exist
                    count--;
                }
                else {
                    ch[i] = 0;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : ch) {
            if (c != 0) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
