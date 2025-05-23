class Solution {
    public int countPrimes(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Invalid input");
        }
        
        boolean[] primes = new boolean[n];
        for (int i = 2; i < primes.length; i++) {
            primes[i] = true;
        }

        for (int i = 2; i * i < primes.length; i++) {
            if (!primes[i]) continue;
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

// [0,1,2,3,4,5,6,7,8,9,10]
// [-,-,-,-,-,-,-,-,-,-, -]
// [-,-,+,+,+,+,+,+,+,+, +]
// [-,-,+,+,-,+,-,+,-,-, -] = 4