class Solution {
    public String reverseVowels(String s) {

        Set<Character> set = new HashSet<>(Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

        char[] arr = s.toCharArray();
        int p1 = 0;
        int p2 = s.length() - 1;

        while (p1 < p2) {
            while (!set.contains(arr[p1]) && p1 < arr.length - 1) p1++;
            while (!set.contains(arr[p2]) && p2 > 0) p2--;

            if (p1 > p2) break;

            char temp = arr[p1];
            arr[p1] = arr[p2];
            arr[p2] = temp;
            p1++;
            p2--;
        }
        
        return new String(arr);
    }
}