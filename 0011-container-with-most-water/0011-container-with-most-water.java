class Solution {
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int amountMax = 0;
        
        while (l < r) {
            int amount = Math.min(height[l], height[r]) * (r - l);
            amountMax = Math.max(amount, amountMax);

            if (height[l] < height[r]) l++;
            else r--;
        }

        return amountMax;
    }
}