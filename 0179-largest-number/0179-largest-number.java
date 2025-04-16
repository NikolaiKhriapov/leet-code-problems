class Solution {
    public String largestNumber(int[] nums) {
        String[] strs = new String[nums.length];

        boolean isMaxZero = true;
        for (int i = 0; i < nums.length; i++) {
            if (isMaxZero && nums[i] > 0) {
                isMaxZero = false;
            }
            strs[i] = String.valueOf(nums[i]);
        }
        if (isMaxZero) {
            return "0";
        }

        Arrays.sort(strs, (a, b) -> (b + a).compareTo(a + b));

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < strs.length; i++) {
            result.append(strs[i]);
        }

        return result.toString();
    }
}