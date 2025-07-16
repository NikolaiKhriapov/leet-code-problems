class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {

        List<Integer> result = new ArrayList<>();

        Arrays.sort(potions);

        for (int i = 0; i < spells.length; i++) {
            int left = 0;
            int right = potions.length - 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if ((long) spells[i] * (long) potions[mid] >= success) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            if ((long) spells[i] * (long) potions[left] >= success) {
                result.add(potions.length - left);
            } else {
                result.add(0);
            }
            
        }
        
        return listToArray(result);
    }

    private static int[] listToArray(List<Integer> list) {
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }
}