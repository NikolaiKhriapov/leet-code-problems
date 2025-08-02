class Solution {
    public List<String> summaryRanges(int[] nums) {
        if (nums == null) {
            throw new IllegalArgumentException("Invalid input");
        }

        List<String> result = new ArrayList<>();

        int left = 0;
        int right = left;
        while (right < nums.length) {
            right++;
            while (right < nums.length && (nums[right] - nums[right - 1] == 1)) {
                right++;
            }
            
            String rangeString;
            if (left == right - 1) {
                rangeString = String.valueOf(nums[left]);
            } else {
                rangeString = nums[left] + "->" + nums[right - 1];
            }
            result.add(rangeString);
            
            left = right;
        }
        
        return result;
    }
}

// time. - O(n)
// space - O(n)