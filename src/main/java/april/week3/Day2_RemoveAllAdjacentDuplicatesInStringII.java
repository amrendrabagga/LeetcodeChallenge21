package april.week3;

import java.util.Stack;

public class Day2_RemoveAllAdjacentDuplicatesInStringII {
    public String removeDuplicates(String s, int k) {
        Stack<Pair> stk = new Stack();
        for (char c : s.toCharArray()) {
            if (stk.isEmpty() || stk.peek().ch != c) {
                stk.push(new Pair(c, 1));
            }
            else {
                Pair p = stk.pop();
                p.update();
                if (p.freq != k) {
                    stk.push(p);
                }
            }
        }

        String res = "";
        while (!stk.isEmpty()) {
            Pair p = stk.pop();
            int t = p.freq;
            while (t-- > 0) {
                res = p.ch + res;
            }
        }
        return res;
    }

    static class Pair {
        char ch;
        int freq;
        Pair(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }
        private void update() {
            this.freq++;
        }
    }
}
