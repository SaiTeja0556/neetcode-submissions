class Solution {
    int inf = Integer.MAX_VALUE;
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp,-1);
        int ans = help(coins,amount,0,dp);
        return ans == inf ? -1 : ans;
    }

    public int help(int[] coins,int amount,int curr,int[] dp){
        if(amount == curr){
            return 0;
        }

        if(amount < curr){
            return inf;
        }

        if(curr < 0) return inf;

        if(dp[curr] != -1) return dp[curr];

        int req = Integer.MAX_VALUE;
        for(int i = 0; i < coins.length; i++){
            int get = help(coins,amount,curr+coins[i],dp);
            if(get == inf) continue;
            req = Math.min(req,get+1);
        }

        return dp[curr] = req;
    }
}
