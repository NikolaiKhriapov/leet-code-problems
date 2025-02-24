class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();

        while (n != 1) {
            n = helper(n);
            if (!set.add(n)) {
                break;
            }
        }
        
        return n == 1;
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