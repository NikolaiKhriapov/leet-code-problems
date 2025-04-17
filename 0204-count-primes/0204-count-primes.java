class Solution {
    public int countPrimes(int n) {
        int count = 0;

        boolean[] primes = new boolean[n];
        for (int i = 2; i < n; i++) {
            primes[i] = true;
        }

        for (int i = 2; i < n; i++) {
            if (primes[i]) {
                count++;
                if (i <= (int) Math.sqrt(n)) {
                    for (int j = i * i; j < n; j += i) {
                        primes[j] = false;
                    }
                }
            }
        }

        return count;
    }
}