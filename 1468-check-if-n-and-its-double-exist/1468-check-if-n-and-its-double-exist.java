class Solution {
    public boolean checkIfExist(int[] arr) {        
        Set<Integer> set = new HashSet<>();
        int zeroes = 0;
        for (int n : arr) {
            if ( (n != 0 && (set.contains(2 * n) || (n % 2 == 0 && set.contains(n / 2)))) || (n == 0 && ++zeroes > 1) ) {
                return true;
            }
            set.add(n);
        }

        return false;
    }
}