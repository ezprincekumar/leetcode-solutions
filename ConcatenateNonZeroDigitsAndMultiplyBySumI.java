public class ConcatenateNonZeroDigitsAndMultiplyBySumI {
    public long sumAndMultiply(int n) {
        int x = 0;
        int temp = n;

        int rev = 0;
        int count = 0;
        while (temp > 0) {
            int digit = temp % 10;
            if (digit != 0) {
                rev = rev * 10 + digit;
                count++;
            }
            temp /= 10;
        }

        while (rev > 0) {
            x = x * 10 + (rev % 10);
            rev /= 10;
        }

        if (count == 0) x = 0;

        int sum = 0, t = x;
        while (t > 0) {
            sum += t % 10;
            t /= 10;
        }
        return (long) x * sum;
    }

    public static void main(String[] args) {
        ConcatenateNonZeroDigitsAndMultiplyBySumI sol = new ConcatenateNonZeroDigitsAndMultiplyBySumI();
        System.out.println(sol.sumAndMultiply(3054)); //4248
        System.out.println(sol.sumAndMultiply(1000)); //1
        System.out.println(sol.sumAndMultiply(123));  //738
    }
}
