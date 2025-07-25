class Solution {
    public boolean isHappy(int n) {
        if (n <= 0) {
            return false;
        }

        int slow = n;
        int fast = helper(n);
        while (slow != fast) {
            slow = helper(slow);
            fast = helper(helper(fast));
        }
        return slow == 1;
    }

    private static int helper(int n) {
        int result = 0;
        while (n > 0) {
            result += (n % 10) * (n % 10);
            n /= 10;
        }
        return result;
    }
}

// time. - O(log n)
// space - O(1)