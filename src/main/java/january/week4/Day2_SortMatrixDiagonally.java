package january.week4;

import java.util.*;

public class Day2_SortMatrixDiagonally {
    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        Map<Integer, List<Integer>> map = new HashMap();
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                int diff = i - j;
                if (!map.containsKey(diff)) {
                    map.put(diff, new ArrayList<Integer>());
                }
                map.get(diff).add(mat[i][j]);
            }
        }

        map.forEach((k,v) -> Collections.sort(v));
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                int diff = i - j;
                mat[i][j] = map.get(diff).get(0);
                map.get(diff).remove(0);
            }
        }
        return mat;
    }

    public int[][] diagonalSortEfficient(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        Map<Integer, PriorityQueue<Integer>> map = new HashMap();
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                map.putIfAbsent(i-j, new PriorityQueue<>());
                map.get(i-j).offer(mat[i][j]);
            }
        }

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                mat[i][j] = map.get(i-j).poll();
            }
        }
        return mat;
    }

        public static void main(String[] args) {
        Day2_SortMatrixDiagonally obj = new Day2_SortMatrixDiagonally();
        System.out.println(obj.diagonalSort(new int[][]{{3,3,1,1},{2,2,1,2},{1,1,1,2}}));

    }
}
