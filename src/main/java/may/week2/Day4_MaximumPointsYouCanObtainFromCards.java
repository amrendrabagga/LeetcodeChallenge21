package may.week2;

public class Day4_MaximumPointsYouCanObtainFromCards {
    public int maxScore(int[] cardPoints, int k) {
        int total = 0;
        for (int i=0; i<cardPoints.length; i++) {
            total += cardPoints[i];
        }
        int res = 0, n = cardPoints.length;
        int window = 0;
        if (n == k) {
            return total;
        }
        for (int i=0; i<n-k-1; i++) {
            window += cardPoints[i];
        }
        for (int i=n-k-1; i<cardPoints.length; i++) {
            window += cardPoints[i];
            res = Math.max(res, total - window);
            window -= cardPoints[i - (n-k-1)];
        }
        return res;
    }
}
