class Solution {
    public int longestPalindrome(String s) {

        char[] arr = s.toCharArray();

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        
        int result = 0;
        for (var entry : map.entrySet()) {
            while (entry.getValue() > 1) {
                result += 2;
                entry.setValue(entry.getValue() - 2);
            }
        }

        for (var entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                result++;
                return result;
            }
        }
   
        return result;
    }
}