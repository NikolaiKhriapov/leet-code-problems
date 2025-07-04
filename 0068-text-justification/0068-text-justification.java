class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {

        List<String> result = new ArrayList<>();
        int wordIndex = 0;

        while (wordIndex < words.length) {
            int firstWordIndex = wordIndex;
            int lastWordIndex = firstWordIndex + 1;
            int currentWidth = words[firstWordIndex].length();

            while (lastWordIndex < words.length && currentWidth + 1 + words[lastWordIndex].length() <= maxWidth) {
                currentWidth += 1 + words[lastWordIndex].length();
                lastWordIndex++;
            }

            boolean isLastLine = lastWordIndex == words.length;
            String line = buildLine(words, maxWidth, firstWordIndex, lastWordIndex - 1, currentWidth, isLastLine);
            result.add(line);

            wordIndex = lastWordIndex;
        }

        return result;        
    }

    private String buildLine(String[] words, int maxWidth, int firstWordIndex, int lastWordIndex, int currentWidth, boolean isLastLine) {
        StringBuilder sb = new StringBuilder();
        if (isLastLine || firstWordIndex == lastWordIndex) {
            for (int wordIndex = firstWordIndex; wordIndex <= lastWordIndex; wordIndex++) {
                sb.append(words[wordIndex]);
                if (wordIndex != lastWordIndex) {
                    sb.append(" ");
                }
            }
            int remainingSpaces = maxWidth - currentWidth;
            while (remainingSpaces-- > 0) {
                sb.append(" ");
            }
        } else {
            int totalWords = lastWordIndex - firstWordIndex + 1;
            int totalSpaces = maxWidth - currentWidth + (totalWords - 1);
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