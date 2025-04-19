class Solution {
    private int[] arrayOriginal;
    private int[] array;
    private static final Random random = new Random();

    public Solution(int[] nums) {
        arrayOriginal = nums.clone();
        array = nums.clone();
    }
    
    public int[] reset() {
        array = arrayOriginal.clone();
        return array;
    }
    
    public int[] shuffle() {
        shuffle(array);
        return array;
    }

    private static void shuffle(int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            swap(array, i, random.nextInt(i + 1));
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */