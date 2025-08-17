class Solution {
    public String largestNumber(int[] nums) {
        if (nums == null) {
            throw new IllegalArgumentException("Invalid input");
        }
        if (nums.length == 0) {
            return "";
        }

        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, (a, b) -> (b + a).compareTo(a + b));

        if (strs[0].equals("0")) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str);
        }

        return sb.toString();
    }
}

// time  - O(n log n)
// space - O(n)
