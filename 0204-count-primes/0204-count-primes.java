class Solution {
    public int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }

        boolean[] primes = new boolean[n];
        Arrays.fill(primes, true);
        primes[0] = false;
        primes[1] = false;

        for (int i = 2; i * i < primes.length; i++) {
            for (int j = i * i; j < primes.length; j += i) {
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