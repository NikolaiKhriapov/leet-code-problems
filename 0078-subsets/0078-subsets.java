class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        recursive(nums, 0, result, list);
        return result;
    }

    private void recursive(int[] nums, int index, List<List<Integer>> result, List<Integer> list) {
        result.add(new ArrayList<>(list));

        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            recursive(nums, i + 1, result, list);
            list.remove(list.size() - 1);
        }
    }
}