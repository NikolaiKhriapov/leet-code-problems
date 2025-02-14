class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums2.length; i++) {
            int n = nums2[i];
            if (stack.isEmpty()) {
                stack.add(n);
            } else {
                if (n <= stack.peek()) {
                    stack.add(n);
                } else {
                    map.put(stack.pop(), n);
                    i--;
                }
            }
        }
        
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = map.getOrDefault(nums1[i], -1);
        }

        return nums1;
    }
}