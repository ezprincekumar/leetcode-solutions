class FindGreatestCommonDivisorOfArray {
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static int findGCD(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        return gcd(min, max);
    }

    public static void main(String[] args) {
        int[] nums = {2, 5, 6, 9, 10};
        System.out.println("GCD of array = " + findGCD(nums));
    }
}
