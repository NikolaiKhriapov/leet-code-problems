class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        

        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String strSorted = sortString(str);
            List<String> list = map.getOrDefault(strSorted, new LinkedList<>());
            list.add(str);
            map.put(strSorted, list);
        }

        List<List<String>> result = new ArrayList<>();
        for (var entry : map.entrySet()) {
            result.add(entry.getValue());
        }

        return result;
    }

    private String sortString(String str) {
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
}