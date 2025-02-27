class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];

        for (int i = 0; i < ans.length; i++) {
            ans[i] = helper(i);
        }

        return ans;
    }

    private int helper(int n) {
        List<Integer> list = new ArrayList<>();
        while (n > 0) {
            list.add(0, n % 2);
            n /= 2;
        }
        
        int count = 0;
        for (int num : list) {
            if (num == 1) {
                count++;
            }
        }

        return count;
    }
}