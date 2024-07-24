class Solution {
    public int[] findErrorNums(int[] nums) {
        
        int[] arr = new int[nums.length];

        for (int n : nums) {
            arr[n - 1] += 1;
        }

        System.out.println(Arrays.toString(arr));

        int[] result = new int[2];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 2) result[0] = i + 1;
            if (arr[i] == 0) result[1] = i + 1;
        }

        return result;
    }
}