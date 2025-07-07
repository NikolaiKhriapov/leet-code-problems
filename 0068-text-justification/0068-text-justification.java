class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        if (words == null || words.length == 0 || maxWidth <= 0) {
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
            boolean isLastLine = rightWordIndex == words.length;
            String line = buildLine(words, maxWidth, currWidth, leftWordIndex, rightWordIndex - 1, isLastLine);
            result.add(line);
            leftWordIndex = rightWordIndex;
        }

        return result;
    }

    private String buildLine(String[] words, int maxWidth, int currWidth, int leftWordIndex, int rightWordIndex, boolean isLastLine) {
        StringBuilder sb = new StringBuilder();
        boolean isSingleWord = leftWordIndex == rightWordIndex;

        if (isLastLine || isSingleWord) {
            for (int wordIndex = leftWordIndex; wordIndex <= rightWordIndex; wordIndex++) {
                sb.append(words[wordIndex]);
                if (wordIndex != rightWordIndex) {
                    sb.append(" ");
                }
            }
            int remainingSpaces = maxWidth - currWidth;
            while (remainingSpaces-- > 0) {
                sb.append(" ");
            }
        } else {
            int wordsTotal = rightWordIndex - leftWordIndex + 1;
            int spacesTotal = maxWidth - currWidth + (wordsTotal - 1);
            int wordSpaces = spacesTotal / (wordsTotal - 1);
            int extraSpaces = spacesTotal % (wordsTotal - 1);
            for (int wordIndex = leftWordIndex; wordIndex <= rightWordIndex; wordIndex++) {
                sb.append(words[wordIndex]);
                if (wordIndex != rightWordIndex) {
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