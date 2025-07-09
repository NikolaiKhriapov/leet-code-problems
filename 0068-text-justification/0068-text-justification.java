class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        if (words == null || maxWidth < 0) {
            throw new IllegalArgumentException("Invalid input");
        }
        if (words.length == 0 || maxWidth == 0) {
            return new ArrayList<>();
        }

        List<String> result = new ArrayList<>();
        
        int leftWordIndex = 0;
        while (leftWordIndex < words.length) {
            int rightWordIndex = leftWordIndex + 1;
            int currWidth = words[leftWordIndex].length();

            while (rightWordIndex < words.length && currWidth + 1 + words[rightWordIndex].length() <= maxWidth) {
                currWidth += 1 + words[rightWordIndex].length();
                rightWordIndex++;
            }

            String line = buildLine(words, maxWidth, currWidth, leftWordIndex, rightWordIndex - 1);
            result.add(line);

            leftWordIndex = rightWordIndex;
        }

        return result;
    }

    private String buildLine(String[] words, int maxWidth, int currWidth, int leftWordIndex, int rightWordIndex) {
        StringBuilder sb = new StringBuilder();
        boolean isLastLine = rightWordIndex == words.length - 1;
        boolean isOnlyWord = leftWordIndex == rightWordIndex;

        if (isLastLine || isOnlyWord) {
            for (int idx = leftWordIndex; idx <= rightWordIndex; idx++) {
                sb.append(words[idx]);
                if (idx != rightWordIndex) {
                    sb.append(" ");
                }
            }
            int remainingSpaces = maxWidth - currWidth;
            while (remainingSpaces-- > 0) {
                sb.append(" ");
            }
        } else {
            int totalWords = rightWordIndex - leftWordIndex + 1;
            int totalSpaces = maxWidth - currWidth + (totalWords - 1);
            int wordSpaces = totalSpaces / (totalWords - 1);
            int extraSpaces = totalSpaces % (totalWords - 1);
            for (int idx = leftWordIndex; idx <= rightWordIndex; idx++) {
                sb.append(words[idx]);
                if (idx != rightWordIndex) {
                    for (int i = 0; i < wordSpaces; i++) {
                        sb.append(" ");
                    }
                }
                if (extraSpaces-- > 0) {
                    sb.append(" ");
                }
            }
        }

        return sb.toString();
    }
}