class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int result = 0;

        int left = 0;
        int right = height.length - 1;
        int leftMax = height[left];
        int rightMax = height[right];
        while (left < right) {
            if (height[left] < height[right]) {
                left++;
                if (height[left] > leftMax) {
                    leftMax = height[left];
                } else {
                    result += leftMax - height[left];
                }
            } else {
                right--;
                if (height[right] > rightMax) {
                    rightMax = height[right];
                } else {
                    result += rightMax - height[right];
                }
            }
        }
        
        return result;
    }
}