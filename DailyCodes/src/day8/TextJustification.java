package day8;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
    public static void main(String[] args) {
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth = 16;
        System.out.println(fullJustify(words, maxWidth));
    }
    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> temp = new ArrayList<>();
        List<String> res = new ArrayList<>();
        int len = 0;
        int wordLen = 0;

        for (String s : words) {
            int n = s.length();
            if (n + len <= maxWidth) {
                len += n;
                len++; // adding space
                wordLen += n;
                temp.add(s);
            } else {
                res.add(helper(temp, maxWidth, wordLen));
                temp.clear();
                len = 0;
                temp.add(s);
                len += n;
                len++;
                wordLen = n;
            }
        }

        // Add the last line
        if (!temp.isEmpty()) {
            res.add(helperLastLine(temp, maxWidth, wordLen));
        }

        return res;
    }

    public static String helper(List<String> words, int maxWidth, int wordLength) {
        int wordCount = words.size();
        int space = maxWidth - wordLength;
        StringBuilder sb = new StringBuilder();
        int spaceCount = wordCount - 1;
        //total space / spaceCount + 1 spaces should be addeded space % spaceCOunt times and then in the end just space / spaceCount times, just dry run and see

        if (spaceCount == 0) {
            // If there's only one word in the line
            sb.append(words.get(0));
            while (sb.length() < maxWidth) {
                sb.append(" ");
            }
            return sb.toString();
        }

        int base = space / spaceCount;
        int rem = space % spaceCount;

        for (int i = 0; i < wordCount; i++) {
            sb.append(words.get(i));
            if (i < wordCount - 1) {
                for (int j = 0; j < base; j++) {
                    sb.append(" ");
                }
                if (rem > 0) {
                    sb.append(" ");
                    rem--;
                }
            }
        }

        return sb.toString();
    }

    public static String helperLastLine(List<String> words, int maxWidth, int wordLength) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.size(); i++) {
            sb.append(words.get(i));
            if (i < words.size() - 1) {
                sb.append(" ");
            }
        }
        while (sb.length() < maxWidth) {
            sb.append(" ");
        }
        return sb.toString();
    }
}
