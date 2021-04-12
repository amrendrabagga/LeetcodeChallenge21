package april.week2;

public class Day5_BeautifulArrangement2 {
    // n = 5 k = 3
    // 1 2 3 4 5; k=1
    // 1 5 4 3 2; k=2
    // 1 5 2 3 4; k=3
    // 1 5 2 4 2; k=4
    // 1 < k < n, so k=5 not possible
    // so here we can see pattern that for k > 1 we fix last value and then set remaining
    // values either in increasing or decreasing order
    public int[] constructArray(int n, int k) {
        int res[] = new int[n];
        int high = n, low = 1;
        int index = 0;
        // flg to keep track whether last element is high or low
        // in order to insert increasing or decreasing remaining values after k operations are done
        boolean isHigh = false;
        res[index++] = low++;
        while (k > 1) {
            res[index++] = high--;
            k--;
            isHigh = true;
            if (k > 1) {
                res[index++] = low++;
                k--;
                isHigh = false;
            }
        }

        while (index < n) {
            if (isHigh) {
                res[index++] = high--;
            }
            else {
                res[index++] = low++;
            }
        }
        return res;
    }
}
