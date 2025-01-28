class Solution {
    public int majorityElement(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();
        int half = nums.length / 2;

        for (int num : nums) {
            Integer val = map.getOrDefault(num, 0) + 1;
            if (val > half) {
                return num;
            } else {
                map.put(num, val);
            }
        }
        
        return -1;
    }
}