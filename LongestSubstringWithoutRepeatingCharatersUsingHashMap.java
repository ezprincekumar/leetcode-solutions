import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharatersUsingHashMap {
  public static int lengthOfLongestSubstring(String s) {
    HashMap<Character, Integer> map = new HashMap<>();
    int left = 0, maxLength = 0;

    for (int right = 0; right < s.length(); right++) {
      char c = s.charAt(right);

      if (map.containsKey(c)) {
        // Jump left pointer to max of current left or last index + 1
        left = Math.max(left, map.get(c) + 1);
      }
      map.put(c, right);
      maxLength = Math.max(maxLength, right - left + 1);
    }
    return maxLength;
  }

  public static void main(String[] args) {
    System.out.println(lengthOfLongestSubstring("abcabcbb")); // 3
    System.out.println(lengthOfLongestSubstring("bbbbb")); // 1
    System.out.println(lengthOfLongestSubstring("pwwkew")); // 3
  }
}
