class Solution {
    public int countPrimes(int n) {
        if (n <= 1) {
            return 0;
        }

        boolean[] primes = new boolean[n];
        for (int i = 2; i < primes.length; i++) {
            primes[i] = true;
        }

        int primesCount = 0;
        for (int i = 2; i < primes.length; i++) {
            if (!primes[i]) {
                continue;
            }
            for (int j = i * i; j < primes.length && i <= Integer.MAX_VALUE / i; j += i) {
                primes[j] = false;
            }
            primesCount++;
        }
        
        return primesCount;
    }
}

// time  - O(n)
// space - O(n)