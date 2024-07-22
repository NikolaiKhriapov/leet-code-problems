class Solution {
    public boolean isHappy(int n) {

        int p1 = n;
        int p2 = n;

        do {
            p1 = calc(p1);
            p2 = calc(calc(p2));
        } while (p1 != p2);

        return p1 == 1;
    }

    private int calc(int n) {
        int sum = 0;
        while (n > 9) {
            int a = n % 10;
            sum += a * a;
            n /= 10;
        }
        sum += n * n;

        return sum;
    }
}