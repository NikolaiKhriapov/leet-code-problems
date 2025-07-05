class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        if (words == null || words.length == 0 || maxWidth <= 0) {
            return new ArrayList<>();
        }

        List<String> result = new ArrayList<>();
        
        int wordIndex = 0;
        while (wordIndex < words.length) {
            int firstWordIndex = wordIndex;
            int lastWordIndex = firstWordIndex + 1;
            int currWidth = words[firstWordIndex].length();
            while (lastWordIndex < words.length && currWidth + 1 + words[lastWordIndex].length() <= maxWidth) {
                currWidth += 1 + words[lastWordIndex].length();
                lastWordIndex++;
            }
            boolean isLastLine = lastWordIndex == words.length;
            String line = buildLine(words, maxWidth, currWidth, firstWordIndex, lastWordIndex - 1, isLastLine);
            result.add(line);
            wordIndex = lastWordIndex;
        }

        return result;
    }

    private String buildLine(String[] words, int maxWidth, int currWidth, int firstWordIndex, int lastWordIndex, boolean isLastLine) {
        StringBuilder sb = new StringBuilder();
        boolean isSingleWord = lastWordIndex == firstWordIndex;
        if (isLastLine || isSingleWord) {
            for (int wordIndex = firstWordIndex; wordIndex <= lastWordIndex; wordIndex++) {
                sb.append(words[wordIndex]);
                if (wordIndex != lastWordIndex) {
                    sb.append(" ");
                }
            }
            int remainingSpaces = maxWidth - currWidth;
            while (remainingSpaces-- > 0) {
                sb.append(" ");
            }
        } else {
            int totalWords = lastWordIndex - firstWordIndex + 1;
            int totalSpaces = maxWidth - currWidth + (totalWords - 1);
            int wordSpaces = totalSpaces / (totalWords - 1);
            int extraSpaces = totalSpaces % (totalWords - 1);
            for (int wordIndex = firstWordIndex; wordIndex <= lastWordIndex; wordIndex++) {
                sb.append(words[wordIndex]);
                if (wordIndex != lastWordIndex) {
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