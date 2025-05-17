class Solution {
    public String largestNumber(int[] nums) {

        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(strs, (a, b) -> (b + a).compareTo(a + b));

        StringBuilder result = new StringBuilder();
        for (String str : strs) {
            result.append(str);
        }

        if (result.indexOf("0") == 0) {
            return "0";
        }

        return result.toString();
    }
}