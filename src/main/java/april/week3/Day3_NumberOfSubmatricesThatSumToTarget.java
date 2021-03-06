package april.week3;

import java.util.HashMap;
import java.util.Map;

public class Day3_NumberOfSubmatricesThatSumToTarget {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;

        for(int row =0; row<m; row++){
            for(int col=1; col<n; col++){
                matrix[row][col] += matrix[row][col-1];
            }
        }
        int count = 0;

        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                Map<Integer,Integer> map = new HashMap<>();
                map.put(0, 1);
                int sum=0;

                for(int row=0; row<m; row++){
                    sum += matrix[row][j] - (i>0 ? matrix[row][i-1] : 0);
                    count += map.getOrDefault(sum-target, 0);
                    map.put(sum, map.getOrDefault(sum, 0) + 1);
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Day3_NumberOfSubmatricesThatSumToTarget obj = new Day3_NumberOfSubmatricesThatSumToTarget();
        System.out.println(obj.numSubmatrixSumTarget(new int[][]{{1,1,1,1}, {1,1,1,1}, {1,1,1,1}, {1,1,1,1}}, 4));
    }
}
