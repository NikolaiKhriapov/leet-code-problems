class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();

        int pa = a.length() - 1;
        int pb = b.length() - 1;
        int n = 0;

        while (pa >= 0 || pb >= 0 || n > 0) {
            int na = (pa >= 0) ? a.charAt(pa) - '0' : 0;
            int nb = (pb >= 0) ? b.charAt(pb) - '0' : 0;
            int sum = na + nb + n;

            sb.append(sum % 2);
            n = sum / 2;

            pa--;
            pb--;
        }

        return sb.reverse().toString();
    }
}