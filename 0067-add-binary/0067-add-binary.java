class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();

        int pa = a.length() - 1;
        int pb = b.length() - 1;
        int carry = 0;

        while (pa >= 0 || pb >= 0 || carry > 0) {
            int na = (pa >= 0) ? a.charAt(pa) - '0' : 0;
            int nb = (pb >= 0) ? b.charAt(pb) - '0' : 0;
            int sum = na + nb + carry;

            sb.append(sum % 2);
            carry = sum / 2;

            pa--;
            pb--;
        }

        String result = sb.toString();

        char[] resultArr = result.toCharArray();
        for (int i = 0; i < resultArr.length / 2; i++) {
            char temp = resultArr[i];
            resultArr[i] = resultArr[resultArr.length - i - 1];
            resultArr[resultArr.length - i - 1] = temp;
        }

        return new String(resultArr);
    }
}