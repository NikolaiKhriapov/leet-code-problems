class Solution {
    public String[] findRelativeRanks(int[] score) {        
        String[] result = new String[score.length];
        for (int i = 0; i < score.length; i++) {
            result[i] = String.valueOf(score[i]);
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < score.length; i++) {
            map.put(score[i], i);
        }

        Arrays.sort(score);

        for (int i = 0; i < score.length; i++) {
            if (i == score.length - 1) result[map.get(score[score.length - 1])] = "Gold Medal";
            else if (i == score.length - 2) result[map.get(score[score.length - 2])] = "Silver Medal";
            else if (i == score.length - 3) result[map.get(score[score.length - 3])] = "Bronze Medal";
            else result[map.get(score[i])] = String.valueOf(score.length - i);
        }

        
        return result;
    }
}