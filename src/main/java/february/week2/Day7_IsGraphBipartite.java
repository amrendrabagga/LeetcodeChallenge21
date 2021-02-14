package february.week2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Day7_IsGraphBipartite {
    public boolean isBipartite(int[][] graph) {
        int V = graph.length;
        int color[] = new int[V];
        Arrays.fill(color, -1);
        for (int i=0; i<V; i++) {
            if (color[i] == -1) {
                if (!isBipartite(graph, i, color)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isBipartite(int[][] graph, int node, int[] color) {

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);
        color[node] = 1;

        while(!queue.isEmpty()) {
            int n = queue.poll();
            for (int t : graph[n]) {
                if (color[t] == color[n]) {
                    return false;
                }
                if (color[t] == -1) {
                    color[t] = 1 - color[n];
                    queue.offer(t);
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Day7_IsGraphBipartite obj = new Day7_IsGraphBipartite();
        System.out.println(obj.isBipartite(new int[][]{{1,3},{0,2},{1,3},{0,2}}));

    }
}
