public class MaximumProductOfTwoDigits {
    public int maxProduct(int n) {
        int max1 = -1, max2 = -1;
        while (n > 0) {
            int digit = n % 10;
            if (digit > max1) {
                max2 = max1;
                max1 = digit;
            } else if (digit > max2) {
                max2 = digit;
            }
            n /= 10;
        }
        return max1 * max2;
    }

    public static void main(String[] args) {
        MaximumProductOfTwoDigits sol = new MaximumProductOfTwoDigits();
        int n = 9274;
        System.out.println("Maximum product of two digits: " + sol.maxProduct(n));
    }
}
