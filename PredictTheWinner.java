class PredictTheWinner {
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            dp[i][i] = nums[i];
        }
        
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
            }
        }
        return dp[0][n - 1] >= 0;
    }

    public static void main(String[] args) {
        PredictTheWinner sol = new PredictTheWinner();
        
        int[] nums1 = {1, 5, 2};
        System.out.println(sol.predictTheWinner(nums1));  //false
        
        int[] nums2 = {1, 5, 233, 7};
        System.out.println(sol.predictTheWinner(nums2));  //true
    }
}
