class Solution {
    public boolean wordPattern(String pattern, String s) {
        
        String[] sArray = s.split(" ");

        if (pattern.length() != sArray.length) return false;

        Map<String, Character> map = new HashMap<>();
        for (int i = 0; i < sArray.length; i++) {
            String curS = sArray[i];
            char curP = pattern.charAt(i);

            if (map.containsKey(curS) && map.get(curS) != curP) {
                return false;
            }
            
            if (!map.containsKey(curS) && map.containsValue(curP)) return false;
            
            map.put(curS, curP);
        }

        return true;
    }
}