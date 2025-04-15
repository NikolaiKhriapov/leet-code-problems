class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for (int i = nums.length - 1; i >= 0; i--) {
            subsets(nums, i, result);
        }
        return result;
    }

    private void subsets(int[] nums, int idx, List<List<Integer>> result) {
        List<List<Integer>> newLists = new ArrayList<>();
        for (List<Integer> list : result) {
            List<Integer> newList = new ArrayList<>(list);
            newList.add(nums[idx]);
            newLists.add(newList);
        }
        result.addAll(newLists);
    }
}