class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        int[] dp = new int[n];
        Arrays.fill(dp,-1);

        dp[0] = nums[0];

        for(int i = 1; i < n; i++){
            int pick = ((i > 1) ? dp[i-2] : 0) + nums[i];
            int notpick = dp[i-1];

            dp[i] = Math.max(pick,notpick);
        }

        // System.out.println(Arrays.toString(dp));

        return dp[n-1];
    }
}
