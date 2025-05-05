class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            throw new IllegalArgumentException("Invalid input"); //for simplicity
        }

        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] strChars = str.toCharArray();
            Arrays.sort(strChars);
            String key = new String(strChars);
            List<String> value = map.getOrDefault(key, new ArrayList<>());
            value.add(str);
            map.put(key, value);
        }
        
        List<List<String>> result = new ArrayList<>();
        for (var entry : map.entrySet()) {
            result.add(entry.getValue());
        }

        return result;
    }
}