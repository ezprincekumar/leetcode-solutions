public class NumberOfUniqueXORTripletsII {
    // FWHT (Fast Walsh-Hadamard Transform)
    private void fwht(long[] a, boolean inverse) {
        int n = a.length;
        for (int len = 1; len < n; len <<= 1) {
            for (int i = 0; i < n; i += (len << 1)) {
                for (int j = 0; j < len; j++) {
                    long u = a[i + j];
                    long v = a[i + j + len];
                    a[i + j] = u + v;
                    a[i + j + len] = u - v;
                }
            }
        }
        if (inverse) {
            for (int i = 0; i < n; i++) {
                a[i] /= n;
            }
        }
    }

    public int numberOfUniqueXorTriplets(int[] nums) {
        int maxVal = 0;
        for (int x : nums) maxVal = Math.max(maxVal, x);
        int size = 1;
        while (size <= maxVal) size <<= 1;
        size <<= 1;

        long[] freq = new long[size];
        for (int x : nums) freq[x]++;

        fwht(freq, false);

        for (int i = 0; i < size; i++) {
            freq[i] = freq[i] * freq[i] * freq[i];
        }

        fwht(freq, true);

        int count = 0;
        for (long val : freq) {
            if (val > 0) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        NumberOfUniqueXORTripletsII sol = new NumberOfUniqueXORTripletsII();
        System.out.println(sol.numberOfUniqueXorTriplets(new int[]{1, 3})); //2
        System.out.println(sol.numberOfUniqueXorTriplets(new int[]{6, 7, 8, 9})); //4
    }
}
