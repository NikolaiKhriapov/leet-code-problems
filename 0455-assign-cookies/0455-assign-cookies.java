class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int result = 0;
        int p1 = 0;
        int p2 = 0;
        
        while (p1 < g.length && p2 < s.length) {
            while (p2 < s.length - 1 && g[p1] > s[p2]) {
                p2++;
            }
            if (g[p1] <= s[p2]) {
                result++;
                p1++;
                p2++;
            } else {
                break;
            }
        }
    
        return result;
    }
}