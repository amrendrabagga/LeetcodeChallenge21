package may.week2;

public class Day3_CountPrimes {
    public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        for (int i=2; i<n; i++) {
            isPrime[i] = true;
        }
        for (int i=2; i * i<n; i++) {
            if (!isPrime[2]) continue;
            for (int j=i*i; j<n; j+=i) {
                isPrime[j] = false;
            }
        }
        int count = 0;
        for (int i=2; i<n; i++) {
            if (isPrime[i]) count++;
        }
        return count;
    }
}
