class Solution {
    public List<List<String>> partition(String s) {

        List<List<String>> result = new ArrayList<>();
        
        partition(s, 0, new ArrayList<>(), result);
        return result;
    }

    private void partition(String s, int index, List<String> curr, List<List<String>> result) {
        if (index == s.length()) {
            result.add(new ArrayList<>(curr));
        }

        int l = index;
        int r = index;
        while (r < s.length()) { 
            boolean isPalindrome = isPalindrome(s, l, r);
            if (isPalindrome) {
                curr.add(s.substring(l, r + 1));
                partition(s, r + 1, curr, result);
                curr.remove(curr.size() - 1);
            }
            r++;
        }
    }

    private boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}