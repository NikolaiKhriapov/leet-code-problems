class Solution {
    public int maxProfit(int k, int[] prices) {
        if (prices == null || k < 0) {
            throw new IllegalArgumentException("Invalid input");
        }
        if (k == 0 || prices.length <= 1) {
            return 0;
        }

        int[] prev = new int[prices.length];
        int[] curr = new int[prices.length];

        for (int i = 1; i <= k; i++) {
            int maxDiff = -prices[0];
            for (int j = 1; j < prices.length; j++) {
                curr[j] = Math.max(curr[j - 1], prices[j] + maxDiff);
                maxDiff = Math.max(maxDiff, prev[j] - prices[j]);
            }
            int[] temp = prev;
            prev = curr;
            curr = temp;
        }
        
        return prev[prices.length - 1];
    }
}

// [3,2,6,5,0,3]

// [0,0,0,0,0,0]
// [0,0,4,4,4,4]
// [0,0,4,4,4,7]

// maxDiff = 4