class Solution {
    public String[] findRelativeRanks(int[] score) {
        
        Map<Integer, String> map = new HashMap<>();

        int[] tmp = score.clone();
        Arrays.sort(tmp);

        for (int i = 0, size = tmp.length; i < size; i++) {
            String placement = String.valueOf(i + 1);
            if (i == 0) placement = "Gold Medal";
            if (i == 1) placement = "Silver Medal";
            if (i == 2) placement = "Bronze Medal";
            
            map.put(tmp[size - 1 - i], placement);
        }

        String[] result = new String[score.length];
        for (int i = 0, size = result.length; i < size; i++) {
            result[i] = map.get(score[i]);
        }

        return result;
    }
}