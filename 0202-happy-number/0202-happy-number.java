class Solution {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = helper(n);

        while (slow != fast && fast != 1) {
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