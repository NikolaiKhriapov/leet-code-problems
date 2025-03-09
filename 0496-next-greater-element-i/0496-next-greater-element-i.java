class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> q = new Stack<>();

        for (int n : nums2) {
            if (q.isEmpty() || q.peek() >= n) {
                q.add(n);
            } else {
                while (!q.isEmpty() && q.peek() < n) {
                    map.put(q.pop(), n);
                }
                q.add(n);
            }
        }
        while (!q.isEmpty()) {
            map.put(q.pop(), -1);
        }

        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = map.get(nums1[i]);
        }

        return nums1;
    }
}