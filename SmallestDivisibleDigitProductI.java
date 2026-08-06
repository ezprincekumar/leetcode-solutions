public class SmallestDivisibleDigitProductI {
    public int smallestNumber(int n, int t) {
        for (int x = n; ; x++) {
            if (digitProduct(x) % t == 0) {
                return x;
            }
        }
    }

    private int digitProduct(int num) {
        int product = 1;
        while (num > 0) {
            product *= (num % 10);
            num /= 10;
        }
        return product;
    }

    public static void main(String[] args) {
        SmallestDivisibleDigitProductI sol = new SmallestDivisibleDigitProductI();
        
        int n1 = 10, t1 = 5;
        System.out.println("Input: n=" + n1 + ", t=" + t1 + " → Output: " + sol.smallestNumber(n1, t1));

        int n2 = 12, t2 = 6;
        System.out.println("Input: n=" + n2 + ", t=" + t2 + " → Output: " + sol.smallestNumber(n2, t2));

        int n3 = 25, t3 = 7;
        System.out.println("Input: n=" + n3 + ", t=" + t3 + " → Output: " + sol.smallestNumber(n3, t3));
    }
}
