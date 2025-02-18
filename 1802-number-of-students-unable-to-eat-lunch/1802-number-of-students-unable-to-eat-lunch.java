class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int[] count = new int[2];

        for (int n : students) {
            count[n]++;
        }
        
        for (int i = 0; i < sandwiches.length; i++) {
            if (--count[sandwiches[i]] < 0) {
                return sandwiches.length - i;
            }
        }

        return 0;
    }
}