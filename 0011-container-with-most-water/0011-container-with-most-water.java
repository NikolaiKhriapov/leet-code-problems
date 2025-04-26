class Solution {
    public int maxArea(int[] height) {

        int areaMax = 0;

        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            int areaCurr = (right - left) * Math.min(height[left], height[right]);
            areaMax = Math.max(areaMax, areaCurr);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        
        return areaMax;
    }
}