package january.week2;

import java.util.*;

public class Day2_WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet();
        for (String word : wordList) {
            words.add(word);
        }
        if (!words.contains(endWord)) return 0;

        Queue<String> queue = new LinkedList();
        queue.offer(beginWord);
        int level = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                String w = queue.poll();
                char[] wrd = w.toCharArray();
                for (int i=0; i<w.length(); i++) {
                    char o = wrd[i];
                    for (char c='a'; c<='z'; c++) {
                        if (wrd[i] == c) continue;
                        wrd[i] = c;
                        String nw = String.valueOf(wrd);
                        if (nw.equals(endWord)) {
                            return level + 1;
                        }
                        if (words.contains(nw)) {
                            queue.offer(nw);
                            words.remove(nw);
                        }
                    }
                    // reset again to original
                    wrd[i] = o;
                }
            }
            level++;
        }
        return 0;
    }
}
