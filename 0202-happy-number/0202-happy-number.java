class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1) {
            if (!set.add(n)) {
                return false;
            }
            n = getProduct(n);
        }
        
        return true;
    }

    private int getProduct(int n) {
        int result = 0;
        
        while (n > 9) {
            result += (n % 10) * (n % 10);
            n /= 10;
        }
        result += n * n;

        return result;
    }
}