class Solution {
    public String[] findRelativeRanks(int[] score) {
        int[] temp = score.clone();
        Arrays.sort(temp);

        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < temp.length; i++) {
            String placement = String.valueOf(i + 1);
            if (i == 0) placement = "Gold Medal";
            if (i == 1) placement = "Silver Medal";
            if (i == 2) placement = "Bronze Medal";
            map.put(temp[temp.length - 1 - i], placement);
        }

        String[] result = new String[score.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = map.get(score[i]);
        }   

        return result;     
    }
}
