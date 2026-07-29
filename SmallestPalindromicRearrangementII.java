class SmallestPalindromicRearrangementII {
    private static final int MAX = 1_000_001;

    public String smallestPalindrome(String s, int k) {
        int n = s.length();
        int halfLen = n / 2;
        String half = s.substring(0, halfLen);
        char mid = (n % 2 == 1) ? s.charAt(halfLen) : 0;

        int[] cnt = new int[26];
        for (char c : half.toCharArray()) cnt[c - 'a']++;

        long total = countWays(cnt);
        if (total < k) return "";

        StringBuilder left = new StringBuilder();
        for (int i = 0; i < halfLen; i++) {
            for (int c = 0; c < 26; c++) {
                if (cnt[c] == 0) continue;
                cnt[c]--;
                long ways = countWays(cnt);
                cnt[c]++;
                if (k <= ways) {
                    left.append((char)('a' + c));
                    cnt[c]--;
                    break;
                } else {
                    k -= ways;
                }
            }
        }

        StringBuilder ans = new StringBuilder(left);
        if (mid != 0) ans.append(mid);
        ans.append(left.reverse());
        return ans.toString();
    }

    private long countWays(int[] cnt) {
        int space = 0;
        for (int v : cnt) space += v;
        long ways = 1;
        for (int v : cnt) {
            if (v == 0) continue;
            ways *= comb(space, v);
            if (ways >= MAX) return MAX;
            space -= v;
        }
        return ways;
    }

    private long comb(int n, int k) {
        k = Math.min(k, n - k);
        long res = 1;
        for (int i = 1; i <= k; i++) {
            res = res * (n - i + 1) / i;
            if (res >= MAX) return MAX;
        }
        return res;
    }

    public static void main(String[] args) {
        SmallestPalindromicRearrangementII sol = new SmallestPalindromicRearrangementII();
        System.out.println(sol.smallestPalindrome("abba", 2)); //baab
    }
}
