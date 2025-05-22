class Solution {
    private int[] arrayOriginal;
    private int[] array;
    private static final Random RANDOM = new Random();

    public Solution(int[] nums) {
        arrayOriginal = Arrays.copyOf(nums, nums.length);
        array = Arrays.copyOf(arrayOriginal, arrayOriginal.length);
    }
    
    public int[] reset() {
        array = Arrays.copyOf(arrayOriginal, arrayOriginal.length);
        return array;
    }
    
    public int[] shuffle() {
        for (int i = array.length - 1; i >= 0; i--) {
            int randomIndex = RANDOM.nextInt(i + 1);
            int temp = array[i];
            array[i] = array[randomIndex];
            array[randomIndex] = temp;
        }
        return array;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */