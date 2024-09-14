class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();

        if (nums.length == 0) {
            return list;
        }

        int startIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1] + 1) {
                if (startIndex == i - 1) {
                    list.add(String.valueOf(nums[startIndex]));
                } else {
                    list.add(nums[startIndex] + "->" + nums[i - 1]);
                }
                startIndex = i;
            }
        }
        if (startIndex == nums.length - 1) {
            list.add(String.valueOf(nums[startIndex]));
        } else {
            list.add(nums[startIndex] + "->" + nums[nums.length - 1]);
        }

        return list;
    }
}