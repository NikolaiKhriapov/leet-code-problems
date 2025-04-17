class Solution {
    public int countPrimes(int n) {
        int count = 0;

        boolean[] primes = new boolean[n];
        for (int i = 2; i < primes.length; i++) {
            primes[i] = true;
        }

        int limit = (int) Math.sqrt(n);
        for (int i = 2; i < n; i++) {
            if (primes[i]) {
                count++;
                if (i <= limit) {
                    for (int j = i * i; j < n; j += i) {
                        primes[j] = false;
                    }
                }
            }
        }
        
        return count;
    }
}