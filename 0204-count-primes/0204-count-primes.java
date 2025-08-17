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
            for (int j = i * 2; j < primes.length && j < Integer.MAX_VALUE; j += i) {
                primes[j] = false;
            }
            primesCount++;
        }
        
        return primesCount;
    }
}

// [0,1,2,3,4,5,6,7,8,9]
// [f,f,t,t,f,t,f,t,f,f]