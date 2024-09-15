class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();

        Map<String, Boolean> added = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            String selected = strs[i];
            if (added.getOrDefault(selected, false)) continue;

            List<String> selectedList = new ArrayList<>();
            selectedList.add(selected);
            
            for (int j = i + 1; j < strs.length; j++) {
                String current = strs[j];
                if (isAnagram(selected, current)) {
                    selectedList.add(current);
                    added.put(current, true);
                }
            }
            result.add(selectedList);
        }
        
        return result;
    }

    private boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            Integer curr = map.getOrDefault(c, 0);
            curr++;
            map.put(c, curr);
        }

        for (int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);
            Integer curr = map.getOrDefault(c, 0);
            if (curr == 0) return false;
            curr--;
            map.put(c, curr);
        }

        return true;
    }
}