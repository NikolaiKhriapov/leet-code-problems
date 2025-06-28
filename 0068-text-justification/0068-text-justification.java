class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {

        List<String> result = new ArrayList<>();
        int wordIndex = 0;

        while (wordIndex < words.length) {
            int currLength = words[wordIndex].length();
            int firstWordIndex = wordIndex;
            int lastWordIndex = wordIndex + 1;

            while (lastWordIndex < words.length && currLength + 1 + words[lastWordIndex].length() <= maxWidth) {
                currLength += 1 + words[lastWordIndex].length();
                lastWordIndex++;
            }

            boolean isLastLine = lastWordIndex == words.length;
            String line = buildLine(words, maxWidth, firstWordIndex, lastWordIndex - 1, currLength, isLastLine);
            
            result.add(line);
            wordIndex = lastWordIndex;
        }
        
        return result;
    }

    private String buildLine(String[] words, int maxWidth, int firstWordIndex, int lastWordIndex, int currWidth, boolean isLastLine) {
        StringBuilder line = new StringBuilder();
        int numWords = lastWordIndex - firstWordIndex + 1;
        
        if (numWords == 1 || isLastLine) {
            for (int w = firstWordIndex; w <= lastWordIndex; w++) {
                line.append(words[w]);
                if (w != lastWordIndex) {
                    line.append(" ");
                }
            }
            int remainingSpaces = maxWidth - line.length();
            while (remainingSpaces-- > 0) {
                line.append(" ");
            }
        } else {
            int totalSpaces = maxWidth - (currWidth - (numWords - 1));
            int spacesPerGap = totalSpaces / (numWords - 1);
            int extraSpaces = totalSpaces % (numWords - 1);

            for (int w = firstWordIndex; w <= lastWordIndex; w++) {
                line.append(words[w]);
                if (w != lastWordIndex) {
                    for (int i = 0; i < spacesPerGap; i++) {
                        line.append(" ");
                    }
                    if (extraSpaces-- > 0) {
                        line.append(" ");
                    }
                }
            }
        }

        return line.toString();
    }
}