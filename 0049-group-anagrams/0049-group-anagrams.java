class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] cArr = str.toCharArray();
            Arrays.sort(cArr);
            String key = new String(cArr);

            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }

        List<List<String>> result = new ArrayList<>();
        result.addAll(map.values());
        
        return result;
    }
}