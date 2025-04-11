class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            String strSorted = sortString(str);
            
            if (!map.containsKey(strSorted)) {
                map.put(strSorted, new ArrayList<>());
            }
            map.get(strSorted).add(str);
        }
        
        List<List<String>> result = new ArrayList<>();
        for (var el : map.entrySet()) {
            result.add(el.getValue());
        }

        return result;
    }

    private String sortString(String str) {
        char[] strArr = str.toCharArray();
        Arrays.sort(strArr);
        return new String(strArr);
    }
}