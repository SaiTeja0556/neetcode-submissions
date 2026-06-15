class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int[] a : dp) Arrays.fill(a,-1);
        return help(coins,0,0,amount,dp);
    }

    public int help(int[] coins,int idx,int curr,int target,int[][] dp){
        if(curr == target) return 1;
        if(curr > target || idx >= coins.length) return 0;
        if(dp[idx][curr] != -1) return dp[idx][curr];

        int take = help(coins,idx,curr+coins[idx],target,dp);
        int nottake = help(coins,idx+1,curr,target,dp);

        return dp[idx][curr] = take+nottake;
    }
}
