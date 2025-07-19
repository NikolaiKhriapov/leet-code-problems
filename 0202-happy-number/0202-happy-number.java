class Solution {
    public boolean isHappy(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Invalid input");
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
            int num = n % 10;
            result += num * num;
            n /= 10;
        }
        return result;
    }
}

// time. - O(log n)
// space - O(log n)