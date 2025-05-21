class Solution {
    public int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }

        boolean[] primes = new boolean[n];
        for (int i = 2; i < primes.length; i++) {
            primes[i] = true;
        }

        for (int i = 2; i * i < primes.length; i++) {
            if (!primes[i]) {
                continue;
            }
            for (int j = i * i; j < primes.length; j += i) {
                primes[j] = false;
            }
        }

        int count = 0;
        for (boolean isPrime : primes) {
            if (isPrime) {
                count++;
            }
        }

        return count;
    }
}