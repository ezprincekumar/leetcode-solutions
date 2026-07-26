import java.util.*;

public class SmallestSubsequenceOfDistinctCharacters {
    public static String smallestSubsequence(String s) {
        int[] freq = new int[26];
        boolean[] inStack = new boolean[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            freq[c - 'a']--;

            if (inStack[c - 'a']) {
                continue;
            }

            while (!stack.isEmpty() && c < stack.peekLast() && freq[stack.peekLast() - 'a'] > 0) {
                char removed = stack.removeLast();
                inStack[removed - 'a'] = false;
            }

            stack.addLast(c);
            inStack[c - 'a'] = true;
        }

        StringBuilder result = new StringBuilder();
        for (char c : stack) {
            result.append(c);
        }

        return result.toString();
    }

    // Example usage
    public static void main(String[] args) {
        String s = "cbacdcbc";
        System.out.println(smallestSubsequence(s)); // Output: "acdb"
    }
}

