public class NumberOfUniqueXORTripletsI {
  public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;

        if (n == 1) return 1;
        if (n == 2) return 2;

        int msb = 31 - Integer.numberOfLeadingZeros(n);

        return 1 << (msb + 1);
    }

    public static void main(String[] args) {
        NumberOfUniqueXORTripletsI sol = new NumberOfUniqueXORTripletsI();

        int[] nums1 = {1, 2};
        System.out.println(sol.uniqueXorTriplets(nums1)); //2

        int[] nums2 = {3, 1, 2};
        System.out.println(sol.uniqueXorTriplets(nums2)); //4

        int[] nums3 = {1};
        System.out.println(sol.uniqueXorTriplets(nums3)); //1

        int[] nums4 = {1, 2, 3, 4, 5};
        System.out.println(sol.uniqueXorTriplets(nums4)); //8
    }
}
