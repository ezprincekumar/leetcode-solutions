import java.util.*;

class SegmentTree {
    private int n;
    private int[] seg;

    private void build(int p, int l, int r, int[] arr) {
        if (l == r) {
            seg[p] = arr[l];
            return;
        }
        int mid = (l + r) >> 1;
        build(p << 1, l, mid, arr);
        build((p << 1) | 1, mid + 1, r, arr);
        seg[p] = Math.max(seg[p << 1], seg[(p << 1) | 1]);
    }

    private int query(int p, int l, int r, int L, int R) {
        if (L <= l && r <= R) return seg[p];
        int mid = (l + r) >> 1, res = 0;
        if (L <= mid) res = Math.max(res, query(p << 1, l, mid, L, R));
        if (R > mid) res = Math.max(res, query((p << 1) | 1, mid + 1, r, L, R));
        return res;
    }

    public SegmentTree(int[] arr) {
        n = arr.length;
        seg = new int[n << 2];
        build(1, 0, n - 1, arr);
    }

    public int query(int L, int R) {
        if (L > R) return 0;
        return query(1, 0, n - 1, L, R);
    }
}

class Solution {
    public List<Integer> maxActiveSectionsAfterTrade(String s, int[][] queries) {
        int n = s.length();
        int cnt1 = 0;
        for (char c : s.toCharArray()) if (c == '1') cnt1++;

        List<Integer> zeroBlocks = new ArrayList<>();
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        
        for (int i = 0; i < n;) {
            int j = i;
            while (j < n && s.charAt(j) == s.charAt(i)) j++;
            if (s.charAt(i) == '0') {
                zeroBlocks.add(j - i);
                left.add(i);
                right.add(j - 1);
            }
            i = j;
        }

        int m = zeroBlocks.size();
        if (m < 2) {
            return new ArrayList<>(Collections.nCopies(queries.length, cnt1));
        }

        int[] sums = new int[m - 1];
        for (int i = 0; i < m - 1; i++) sums[i] = zeroBlocks.get(i) + zeroBlocks.get(i + 1);
        SegmentTree seg = new SegmentTree(sums);

        List<Integer> ans = new ArrayList<>();
        for (int[] q : queries) {
            int l = q[0], r = q[1];
            int idx = lowerBound(right, l);
            int jdx = upperBound(left, r) - 1;

            if (idx > m - 1 || jdx < 0 || idx >= jdx) {
                ans.add(cnt1);
                continue;
            }

            int firstLen = right.get(idx) - Math.max(left.get(idx), l);
            int lastLen = Math.min(right.get(jdx), r + 1) - left.get(jdx);

            if (idx + 1 == jdx) {
                ans.add(cnt1 + firstLen + lastLen);
                continue;
            }

            int val1 = firstLen + zeroBlocks.get(idx + 1);
            int val2 = zeroBlocks.get(jdx - 1) + lastLen;
            int val3 = seg.query(idx + 1, jdx - 2);

            ans.add(cnt1 + Math.max(Math.max(val1, val2), val3));
        }
        return ans;
    }

    private int lowerBound(List<Integer> list, int target) {
        int l = 0, r = list.size();
        while (l < r) {
            int mid = (l + r) / 2;
            if (list.get(mid) < target) l = mid + 1;
            else r = mid;
        }
        return l;
    }

    private int upperBound(List<Integer> list, int target) {
        int l = 0, r = list.size();
        while (l < r) {
            int mid = (l + r) / 2;
            if (list.get(mid) <= target) l = mid + 1;
            else r = mid;
        }
        return l;
    }
}

public class MaximizeActiveSectionWithTradeII {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = "110001100";
        int[][] queries = {{0, 5}, {2, 8}, {1, 3}};
        List<Integer> result = sol.maxActiveSectionsAfterTrade(s, queries);
        System.out.println(result); //[4, 7, 4]
    }
}
