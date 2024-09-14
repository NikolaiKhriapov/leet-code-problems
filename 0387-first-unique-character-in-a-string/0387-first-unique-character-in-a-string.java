class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();

        char[] sa = s.toCharArray();
        for (int i = 0; i < sa.length; i++) {
            map.put(sa[i], map.getOrDefault(sa[i], 0) + 1);
        }

        for (int i = 0; i < sa.length; i++) {
            if (map.get(sa[i]) == 1) {
                return i;
            }
        }

        return -1;
    }
}