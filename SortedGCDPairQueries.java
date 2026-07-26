import java.util.*;

public class SortedGCDPairQueries {
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example input
        int[] nums = {2, 4, 6, 8};
        long[] queries = {0, 1, 2, 3, 4, 5};

        int[] result = sol.gcdValues(nums, queries);

        // Print results
        System.out.println(Arrays.toString(result));
    }
}

class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {
        int max = Arrays.stream(nums).max().getAsInt();
        int[] freq = new int[max + 1];
        for (int v : nums) freq[v]++;

        long[] multiples = new long[max + 1];
        for (int g = 1; g <= max; g++) {
            for (int m = g; m <= max; m += g) multiples[g] += freq[m];
        }

        long[] gcdPairs = new long[max + 1];
        for (int g = max; g >= 1; g--) {
            long cnt = multiples[g] * (multiples[g] - 1) / 2;
            for (int m = 2 * g; m <= max; m += g) cnt -= gcdPairs[m];
            gcdPairs[g] = cnt;
        }

        long[] prefix = new long[max + 1];
        for (int g = 1; g <= max; g++) prefix[g] = prefix[g - 1] + gcdPairs[g];

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            long rank = queries[i] + 1L; // queries are 0-based indices
            ans[i] = findGForRank(prefix, rank);
        }
        return ans;
    }

    private int findGForRank(long[] prefix, long rank) {
        int l = 1, r = prefix.length - 1;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (prefix[mid] >= rank) r = mid;
            else l = mid + 1;
        }
        return l;
    }
}
