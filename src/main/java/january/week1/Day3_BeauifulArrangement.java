package january.week1;

public class Day3_BeauifulArrangement {
    int count = 0;
    public int countArrangement(int n) {
        if (n <= 0) return count;
        boolean visited[] = new boolean[n+1];
        countArrangementUtils(visited, 1, n);
        return count;
    }
    public void countArrangementUtils(boolean []visited, int index, int n) {
        if (index > n) {
            count++;
            return;
        }
        for (int i=1; i<=n; i++) {
            if (!visited[i] && (i % index == 0 || index % i == 0)) {
                visited[i] = true;
                countArrangementUtils(visited, index+1, n);
                visited[i] = false;
            }
        }
    }
}
