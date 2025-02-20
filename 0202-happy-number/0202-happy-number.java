class Solution {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = getProduct(n);

        while (slow != fast && fast != 1) {
            slow = getProduct(slow);
            fast = getProduct(getProduct(fast));
        }

        return fast == 1;
    }

    private int getProduct(int n) {
        int result = 0;
        while (n > 0) {
            result += (n % 10) * (n % 10);
            n /= 10;
        }
        return result;
    }
}