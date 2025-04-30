class Solution {
    private int[] array;
    private int[] originalArray;
    private static final Random random = new Random();

    public Solution(int[] nums) {
        array = Arrays.copyOf(nums, nums.length);
        originalArray = Arrays.copyOf(nums, nums.length);
    }
    
    public int[] reset() {
        array = Arrays.copyOf(originalArray, originalArray.length);
        return array;
    }
    
    public int[] shuffle() {
        shuffleArray(array);
        return array;
    }

    private static void shuffleArray(int[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            int randomIndex = random.nextInt(i + 1);
            int temp = arr[i];
            arr[i] = arr[randomIndex];
            arr[randomIndex] = temp;
        }
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */