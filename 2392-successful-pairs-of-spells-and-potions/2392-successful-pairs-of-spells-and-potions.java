class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length, m = potions.length;
        int[] answer = new int[n];

        // 1. sort potions
        Arrays.sort(potions);

        // 2. decorate spells with original indices and sort descending by spell value
        int[][] decorated = new int[n][2];          // [spell, originalIdx]
        for (int i = 0; i < n; i++) {
            decorated[i][0] = spells[i];
            decorated[i][1] = i;
        }
        Arrays.sort(decorated, (a, b) -> Integer.compare(b[0], a[0])); // descending

        // 3. two-pointer sweep
        int j = 0;
        for (int[] pair : decorated) {
            int spell = pair[0];
            int idx   = pair[1];

            // smallest potion that works for this spell
            long minPotion = (success + spell - 1L) / spell; // ceil division

            // advance j until potions[j] >= minPotion
            while (j < m && potions[j] < minPotion) {
                j++;
            }
            answer[idx] = m - j; // could be zero
        }
        return answer;
    }
}