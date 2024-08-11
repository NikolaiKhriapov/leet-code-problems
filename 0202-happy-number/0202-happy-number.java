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

    private int calcSquared(int n) {
        int a = 0;
        while (n > 0) {
            a += Math.pow(n % 10, 2);
            n /= 10;
        }
        return a;
    }
}