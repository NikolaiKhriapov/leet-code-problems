class Solution {
    public String largestNumber(int[] nums) {

        boolean isZero = true;

        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (isZero && nums[i] != 0) {
                isZero = false;
            }
            strs[i] = String.valueOf(nums[i]);
        }

        if (isZero) return "0";

        Arrays.sort(strs, (a, b) -> (b + a).compareTo(a + b));
        
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str);
        }

        return sb.toString();
    }
}