class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];

        for (int j = 0; j < nums1.length; j++) {
            int n = nums1[j];
            Stack<Integer> stack = new Stack<>();
            for (int i = nums2.length - 1; i >= 0; i--) {
                if (nums2[i] == n) {
                    break;
                }
                stack.add(nums2[i]);
            }
            int res = -1;
            while (!stack.isEmpty()) {
                int num = stack.pop();
                if (num > n) {
                    res = num;
                    break;
                }
            }
            result[j] = res;
        }
        
        return result;
    }
}