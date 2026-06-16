class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if(n == 1) return nums[0];

        int[] dp = new int[n];
        // Arrays.fill(dp,-1);

        // int ans1 = help(nums,n-2,true,dp);

        // Arrays.fill(dp,-1);

        // int ans2 = help(nums,n-1,false,dp);


        int ans1 = 0,ans2 = 0;

        for(int i = 0; i < n-1; i++){
            int pick = nums[i],notpick = 0;
            if(i > 1) pick += dp[i-2];
            if(i > 0) notpick += dp[i-1];

            dp[i] = Math.max(pick,notpick);
        }

        ans1 = dp[n-2];

        Arrays.fill(dp,0);

        for(int i = 1; i < n; i++){
            int pick = nums[i],notpick = 0;
            if(i > 1) pick += dp[i-2];
            if(i > 0) notpick += dp[i-1];

            dp[i] = Math.max(pick,notpick);
        }

        ans2 = dp[n-1];

        return Math.max(ans1,ans2);
    }

    // public int help(int[] nums,int idx,boolean first,int[] dp){

    //     if(first){
    //         if(idx == 0) return nums[0];
    //         if(idx < 0) return 0; 
    //     }

    //     if(!first){
    //         if(idx <= 0) return 0;
    //         if(idx == 1) return nums[1];
    //     }

    //     if(dp[idx] != -1) return dp[idx];

    //     int pick = nums[idx] + help(nums,idx-2,first,dp);
    //     int notpick = help(nums,idx-1,first,dp);

    //     return dp[idx] = Math.max(pick,notpick);
    // }
}
