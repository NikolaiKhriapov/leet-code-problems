class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] strArr = str.toCharArray();
            Arrays.sort(strArr);
            String strSorted = String.valueOf(strArr);
            
            List<String> entryValue = map.getOrDefault(strSorted, new ArrayList<>());
            entryValue.add(str);
            map.put(strSorted, entryValue);
        }
        
        List<List<String>> result = new ArrayList<>();
        for (var el : map.entrySet()) {
            result.add(el.getValue());
        }

        return result;
    }
}