class Solution {
    public String reverseWords(String s) {
        char[] sArr = s.toCharArray();

        int pl = 0;
        int pr = 0;

        while (pr < sArr.length) {
            while (pr < sArr.length && sArr[pr] != ' ') {
                pr++;
            }

            reverse(sArr, pl, pr - 1);

            pr++;
            pl = pr;
        }
        
        return new String(sArr);
    }

    private void reverse(char[] arr, int l, int r) {
        while (l < r) {
            char t = arr[l];
            arr[l] = arr[r];
            arr[r] = t;
            l++;
            r--;
        }
    }
}