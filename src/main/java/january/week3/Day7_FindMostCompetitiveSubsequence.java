package january.week3;

import java.util.Arrays;
import java.util.Stack;

public class Day7_FindMostCompetitiveSubsequence {
    public int[] mostCompetitive(int[] nums, int k) {
        int rem = nums.length - k;
        // no of times we can remove element such that size of resultant can be of size k
        Stack<Integer> stk = new Stack();
        for (int num : nums) {
            while (!stk.isEmpty() && rem > 0 && num < stk.peek()) {
                stk.pop();
                rem--;
            }
            stk.push(num);
        }
        while (rem > 0) {
            stk.pop();
            rem--;
        }
        int res[] = new int[k];
        int j = k - 1;
        while (!stk.isEmpty()) {
            res[j] = stk.pop();
            j--;
        }
        return res;
    }

    public static void main(String[] args) {
        Day7_FindMostCompetitiveSubsequence obj = new Day7_FindMostCompetitiveSubsequence();
        System.out.println(Arrays.toString(obj.mostCompetitive(new int[]{3, 5, 2, 6}, 2)));

    }
}
