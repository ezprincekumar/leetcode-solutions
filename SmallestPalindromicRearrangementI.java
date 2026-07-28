class SmallestPalindromicRearrangementI {
    public String smallestPalindrome(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        StringBuilder left = new StringBuilder();
        String middle = "";

        for (int i = 0; i < 26; i++) {
            if (freq[i] % 2 == 1) {
                middle = String.valueOf((char) (i + 'a'));
            }
            for (int j = 0; j < freq[i] / 2; j++) {
                left.append((char) (i + 'a'));
            }
        }

        String right = new StringBuilder(left).reverse().toString();
        return left.toString() + middle + right;
    }

    public static void main(String[] args) {
        SmallestPalindromicRearrangementI sol = new SmallestPalindromicRearrangementI();

        String test1 = "babab";
        String test2 = "daccad";
        String test3 = "racecar";

        System.out.println("Input: " + test1 + " → Output: " + sol.smallestPalindrome(test1));
        System.out.println("Input: " + test2 + " → Output: " + sol.smallestPalindrome(test2));
        System.out.println("Input: " + test3 + " → Output: " + sol.smallestPalindrome(test3));
    }
}
