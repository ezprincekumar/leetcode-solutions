public class ReverseInteger {
    public static int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;

            rev = rev * 10 + pop;
        }
        return rev;
    }

    public static void main(String[] args) {
        int num1 = 123;
        int num2 = -123;
        int num3 = 120;
        int num4 = 1534236469;

        System.out.println(reverse(num1)); // 321
        System.out.println(reverse(num2)); // -321
        System.out.println(reverse(num3)); // 21
        System.out.println(reverse(num4)); // 0
    }
}
