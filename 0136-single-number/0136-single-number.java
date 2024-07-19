class Solution {
    public int singleNumber(int[] nums) {
        
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> unique = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            if (!unique.contains(nums[i])) {
                unique.add(nums[i]);
            } else {
                unique.remove(unique.indexOf(nums[i]));
            }
        }

        return unique.get(0);
    }
}