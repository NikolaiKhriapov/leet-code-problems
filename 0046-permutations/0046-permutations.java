class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permute(nums, result, new ArrayList<>());
        return result;
    }

    private void permute(int[] nums, List<List<Integer>> result, List<Integer> curr) {
        for (int i = 0; i < nums.length; i++) {
            if (curr.contains(nums[i])) continue;

            List<Integer> temp = copyList(curr);

            curr.add(nums[i]);

            if (curr.size() == nums.length) {
                result.add(curr);
            } else {
                permute(nums, result, curr);
            }

            curr = temp;
        }
    }

    private List<Integer> copyList(List<Integer> original) {
        List<Integer> copy = new ArrayList<>();
        for (int n : original) {
            copy.add(n);
        }
        return copy;
    }
}