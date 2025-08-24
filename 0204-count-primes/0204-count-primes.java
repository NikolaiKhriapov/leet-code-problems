class Solution {
    public int countPrimes(int n) {
        if (n <= 1) {
            return 0;
        }

        boolean[] primes = new boolean[n];
        for (int i = 2; i < primes.length; i++) {
            primes[i] = true;
        }
        
        for (int i = 2; i < primes.length; i++) {
            if (!primes[i]) {
                continue;
            }
            if (i >= Integer.MAX_VALUE / i) {
                break;
            }
            for (int j = i * i; j < primes.length; j += i) {
                primes[j] = false;
            }
        }

        int primeCount = 0;
        for (boolean isPrime : primes) {
            if (isPrime) {
                primeCount++;
            }
        }

        return primeCount;
    }
}

// time  - O(log log n)
// space - O(n)

// [0,1,2,3,4,5,6,7,8,9,10]
// [f,f,t,t,f,t,f,t,f,f,f ]