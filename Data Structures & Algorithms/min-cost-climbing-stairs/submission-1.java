class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];

        Arrays.fill(dp1,-1);
        Arrays.fill(dp2,-1);

        help(cost,0,dp1);
        help(cost,1,dp2);

        return Math.min(help(cost,0,dp1),help(cost,1,dp2));
    }

    public int help(int[] cost,int idx,int[] dp){
        if(idx >= cost.length){
            
            return 0;
        }

        if(dp[idx] != -1){
            return dp[idx];
        }

        int step1 = help(cost,idx+1,dp)+cost[idx];
        int step2 = help(cost,idx+2,dp)+cost[idx];
        
        return dp[idx] = Math.min(step1,step2);
    }
}
