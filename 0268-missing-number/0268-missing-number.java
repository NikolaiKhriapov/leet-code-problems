class Solution {
    public int missingNumber(int[] nums) {

        boolean[] visited = new boolean[10001];

        for (int n : nums) {
            visited[n] = true;
        }
        
        for (int i = 0; i <= nums.length; i++) {
            if (!visited[i]) return i;
        }

        return -1;
    }
}