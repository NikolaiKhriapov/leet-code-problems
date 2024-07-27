class Solution {
    public String reverseWords(String s) {

        String[] arr = s.split(" ");

        StringBuilder sb = new StringBuilder();
        for (String part : arr) {
            part = reverse(part);
            sb.append(part).append(" ");
        }

        return sb.toString().strip();
    }

    private String reverse(String s) {

        char[] arr = s.toCharArray();

        int l = 0;
        int r = arr.length - 1;

        while (l < r) {
            char tmp = arr[l];
            arr[l] = arr[r];
            arr[r] = tmp;
            l++;
            r--;
        }

        return new String(arr);
    }
}