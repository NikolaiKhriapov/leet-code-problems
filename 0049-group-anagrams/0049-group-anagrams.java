class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            char[] cArr = str.toCharArray();
            Arrays.sort(cArr);
            String key = new String(cArr);

            List<String> list = map.getOrDefault(key, new ArrayList<>());

            list.add(str);
            map.put(key, list);
        }

        for (var entry : map.entrySet()) {
            result.add(entry.getValue());
        }
        
        return result;
    }

    private boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        int[] count = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }

        for (int n : count) {
            if (n != 0) {
                return false;
            }
        }

        return true;
    }
}