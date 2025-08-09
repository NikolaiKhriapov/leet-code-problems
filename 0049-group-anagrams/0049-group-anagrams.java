class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null) {
            throw new IllegalArgumentException("Invalid input");
        }

        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String key = buildKey(str);
            if (map.containsKey(key)) {
                map.get(key).add(str);
            } else {
                map.put(key, new ArrayList<>(List.of(str)));
            }
        }

        List<List<String>> result = new ArrayList<>();
        for (List<String> list : map.values()) {
            result.add(list);
        }

        return result;
    }

    private String buildKey(String str) {
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        return String.valueOf(arr);
    }

}

// time  - O(n * mlogm)
// space - O(n * m)
