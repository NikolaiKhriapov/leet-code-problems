class Solution {
    public boolean isHappy(int n) {

        int slow = n;
        int fast = n;

        do {
            slow = calcSquared(slow);
            fast = calcSquared(calcSquared(fast));
        } while (slow != fast);

        return slow == 1;
    }

    public int calcSquared(int n) {
        int result = 0;
        while (n > 0) {
            int tmp = n % 10;
            result += tmp * tmp;
            n /= 10;
        }
        return result;
    }
}

        // Set<Integer> set = new HashSet<>();
        
        // while (n != 1) {
        //     int answer = 0;
        //     while (n > 0) {
        //         int remainder = n % 10;
        //         answer += remainder * remainder;
        //         n /= 10;
        //     }
        //     boolean isAdded = set.add(answer);
        //     if (!isAdded) return false;
        //     n = answer;
        // }

        // return true;
