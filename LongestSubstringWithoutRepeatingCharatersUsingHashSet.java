import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharatersUsingHashSet {
  public static int lengthOfLongestSubstring(String s) {
    HashSet<Character> set = new HashSet<>();
    int left = 0, maxLength = 0;

    for (int right = 0; right < s.length(); right++) {
      // If duplicate found, shrink from left
      while (set.contains(s.charAt(right))) {
        set.remove(s.charAt(left));
        left++;
      }
      // Add current character
      set.add(s.charAt(right));
      // Update max length
      maxLength = Math.max(maxLength, right - left + 1);
    }
    return maxLength;
  }

  public static void main(String[] args) {
    System.out.println(lengthOfLongestSubstring("abcabcbb")); // Output: 3
    System.out.println(lengthOfLongestSubstring("bbbbb")); // Output: 1
    System.out.println(lengthOfLongestSubstring("pwwkew")); // Output: 3
  }
}