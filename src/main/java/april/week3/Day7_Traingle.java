package april.week3;

import java.util.List;

public class Day7_Traingle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] dp = triangle.get(triangle.size() - 1)
                .stream().mapToInt(Integer::intValue).toArray();
        int i = triangle.size() - 2;
        for (; i>=0; i--) {
            for (int j=0; j<triangle.get(i).size(); j++) {
                dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j+1]);
            }
        }
        return dp[0];
    }
}
