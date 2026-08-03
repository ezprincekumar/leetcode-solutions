public class StoneGameIII {
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        int[] dp = new int[n + 1];

        dp[n] = 0;

        for (int i = n - 1; i >= 0; i--) {
            int take = 0;
            dp[i] = Integer.MIN_VALUE;
            for (int k = 0; k < 3 && i + k < n; k++) {
                take += stoneValue[i + k];
                dp[i] = Math.max(dp[i], take - dp[i + k + 1]);
            }
        }

        if (dp[0] > 0) return "Alice";
        else if (dp[0] < 0) return "Bob";
        else return "Tie";
    }

    public static void main(String[] args) {
        StoneGameIII sol = new StoneGameIII();
        int[] stones1 = {1,2,3,7};
        int[] stones2 = {1,2,3,-9};
        int[] stones3 = {1,2,3,6};

        System.out.println(sol.stoneGameIII(stones1)); //Bob
        System.out.println(sol.stoneGameIII(stones2)); //Alice
        System.out.println(sol.stoneGameIII(stones3)); //Tie
    }
}
