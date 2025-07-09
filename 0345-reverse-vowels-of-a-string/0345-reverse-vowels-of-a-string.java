class Solution {
    private static final Set<Character> VOWELS = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');

    public String reverseVowels(String s) {
        char[] arr = s.toCharArray();

        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            while (left < right && !VOWELS.contains(arr[left])) {
                left++;
            }
            while (left < right && !VOWELS.contains(arr[right])) {
                right--;
            }
            if (left < right) {
                swap(arr, left, right);
            }
            left++;
            right--;
        }
        
        return String.valueOf(arr);
    }

    private void swap(char[] arr, int p1, int p2) {
        char temp = arr[p1];
        arr[p1] = arr[p2];
        arr[p2] = temp;
    }
}