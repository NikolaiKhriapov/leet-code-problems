class Solution {
    public int countPrimes(int n) {
        if (n < 2) {
            return 0;
        }

        boolean[] primes = new boolean[n];
        Arrays.fill(primes, true);
        primes[0] = false;
        primes[1] = false;

        for (int i = 2; i < primes.length; i++) {
            for (int j = i * 2; j < n; j += i) {
                primes[j] = false;
            }
        }
        
        int count = 0;
        for (boolean prime : primes) {
            if (prime) {
                count++;
            }
        }

        return count;
    }
}