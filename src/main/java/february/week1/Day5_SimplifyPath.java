package february.week1;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Day5_SimplifyPath {
    public String simplifyPath(String path) {
        String[] s = path.split("/");
        Stack<String> stk = new Stack();
        for (String t : s) {
            if (!stk.isEmpty() && t.equals("..")) {
                stk.pop();
            }
            else if (!t.equals("") && !t.equals(".") && !t.equals("..")) {
                stk.push(t);
            }
        }
        List<String> l = new ArrayList(stk);
        return "/" + String.join("/", l);
    }
}
