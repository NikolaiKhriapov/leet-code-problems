class Solution {
    public boolean checkIfExist(int[] arr) {        
        Set<Integer> set = new HashSet<>();
        int zeroes = 0;
        for (int n : arr) {
            if (n == 0) zeroes++;
            set.add(n);
        }

        if (zeroes > 1) return true;
        for (int n : arr) {
            if (n != 0 && set.contains(2 * n)) {
                return true;
            }
        }

        return false;
    }
}