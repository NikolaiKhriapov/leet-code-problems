class Solution {
    public boolean checkIfExist(int[] arr) {

        Set<Integer> set = new HashSet<>();

        for (int n : arr) {
            set.add(n);
        }

        for (int n : arr) {
            if (n != 0 && set.contains(2 * n)) return true;
        }

        return false;
    }
}
