package may.week1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Day1_PrefixAndSuffixSearch {

    TrieNode suffix;
    TrieNode prefix;
    public Day1_PrefixAndSuffixSearch(String[] words) {
        prefix = new TrieNode();
        suffix = new TrieNode();
        for (int i=0; i<words.length; i++) {
            prefix.insert(words[i], i);
            suffix.insert(new StringBuilder(words[i]).reverse().toString(), i);
        }
    }

    public int f(String pre, String suff) {
        List<Integer> pList = prefix.startsWith(pre);
        List<Integer> sList = suffix.startsWith(new StringBuilder(suff).reverse().toString());
        int i = pList.size() - 1, j = sList.size() - 1;
        while (i >= 0 && j >= 0) {
            if (Objects.equals(pList.get(i), sList.get(j))) {
                return pList.get(i);
            }
            else if(pList.get(i) > sList.get(j)) {
                i--;
            }
            else {
                j--;
            }
        }
        return -1;
    }

    static class TrieNode {
        TrieNode[] children;
        List<Integer> index;

        TrieNode() {
            children = new TrieNode[26];
            index = new ArrayList();
        }

        void insert(String word, int i) {
            TrieNode root = this;
            for (char c : word.toCharArray()) {
                if (root.children[c - 'a'] == null) {
                    root.children[c - 'a'] = new TrieNode();
                }
                root = root.children[c - 'a'];
                root.index.add(i);
            }
        }

        List<Integer> startsWith(String word) {
            TrieNode root = this;
            for (char c : word.toCharArray()) {
                if (root.children[c - 'a'] == null) {
                    return new ArrayList();
                }
                root = root.children[c - 'a'];
            }
            return root.index;
        }
    }

    public static void main(String[] args) {
        Day1_PrefixAndSuffixSearch obj = new Day1_PrefixAndSuffixSearch(new String[]{"apple"});
        System.out.println(obj.f("a", "e"));
    }
}
