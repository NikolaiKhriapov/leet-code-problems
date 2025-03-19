class Solution {
    public boolean isHappy(int n) {
        int slow = helper(n);
        int fast = helper(helper(n));

        while (fast != 1 && slow != fast) {
            slow = helper(slow);
            fast = helper(helper(fast));
        }
        return fast == 1;
    }

    private int helper(int n) {
        int result = 0;
        while (n > 0) {
            result += (n % 10) * (n % 10);
            n /= 10;
        }
        return result;
    }
}