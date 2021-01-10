package january.week2;

public class Day3_CreateSortedArrayThroughInstructions {
    int mod = 1000000007;
    int bit[] = new int[100002];
    // index will represent value of input array and value of bit[]
    // is representing frequency, cause we need to take care of no of elements less than
    // and greater than given no
    private int sum(int i) {// get sum till ith index
        int ans = 0;
        for (int j=i; j>0; j-=(j&-j)) {
            // j ^ (j & (j-1)) or j & -j returns rightmmost bit
            ans += bit[j];
        }
        return ans;
    }
    private void update(int i) {// update from ith to n
        for (int j=i; j<=100001; j+=(j&-j)) {
            // j ^ (j & (j-1)) or j & -j returns rightmost bit
            bit[j] += 1;// here we are simply adding 1 to frequency of ith
        }
    }

    public int createSortedArray(int[] instructions) {
        int n = instructions.length;
        int ans = 0;
        for (int i=0; i<n; i++) {
            ans += Math.min(sum(instructions[i] - 1), i - sum(instructions[i]));
            ans %= mod;
            update(instructions[i]);
        }
        return ans;
    }
}
