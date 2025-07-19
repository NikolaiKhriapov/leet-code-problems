class Solution {
    public boolean isHappy(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Invalid input");
        }
        
        Set<Integer> set = new HashSet<>();
        while (n > 1 && set.add(n)) {
            n = helper(n);
        }
        return n == 1;        
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

// time. - O(n)
// space - O(1)