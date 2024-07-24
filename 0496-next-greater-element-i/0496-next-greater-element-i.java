class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        Map<Integer, Integer> map = new HashMap<>();

        Stack<Integer> stack = new Stack<>();
        for (int n : nums2) {
            while (!stack.empty() && stack.peek() < n) {
                map.put(stack.pop(), n);
            }
            stack.add(n);
        }

        int[] result = new int[nums1.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = map.getOrDefault(nums1[i], -1);
        }
        return result;
    }
}