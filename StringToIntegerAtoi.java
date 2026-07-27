public class StringToIntegerAtoi {
    public int myAtoi(String s) {
        if (s == null || s.length() == 0) return 0;

        int i = 0, n = s.length();
        while (i < n && s.charAt(i) == ' ') i++;

        int sign = 1;
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }

        long result = 0;
        while (i < n && Character.isDigit(s.charAt(i))) {
            result = result * 10 + (s.charAt(i) - '0');

            if (sign == 1 && result > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (sign == -1 && -result < Integer.MIN_VALUE) return Integer.MIN_VALUE;

            i++;
        }
        return (int) result * sign;
    }

    public static void main(String[] args) {
        StringToIntegerAtoi sol = new StringToIntegerAtoi();
        System.out.println(sol.myAtoi("42"));   //42
        System.out.println(sol.myAtoi("   -42"));   //-42
        System.out.println(sol.myAtoi("4193 with words"));  //4193
        System.out.println(sol.myAtoi("words and 987"));    //0
        System.out.println(sol.myAtoi("-91283472332")); //-2147483648
    }
}
