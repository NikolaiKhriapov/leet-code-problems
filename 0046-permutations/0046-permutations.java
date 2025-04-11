class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permute(nums, result, new ArrayList<>(), new boolean[nums.length]);
        return result;
    }

    private void permute(int[] nums, List<List<Integer>> result, List<Integer> curr, boolean[] visited) {
        if (curr.size() == nums.length) {
            result.add(new ArrayList<>(curr));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;

            curr.add(nums[i]);;
            visited[i] = true;
            
            permute(nums, result, curr, visited);
            
            curr.remove(curr.size() - 1);
            visited[i] = false;
        }
    }
}
