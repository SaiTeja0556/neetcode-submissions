class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp,-1);
        return help(s,0,dp);
    }

    public int help(String s,int idx,int[] dp){
        if(idx >= s.length()){
            return 1;
        }

        if(dp[idx] != -1) return dp[idx];

        int ways = 0;

        if(s.charAt(idx) != '0') ways += help(s,idx+1,dp);

        if(idx+1 < s.length() && s.charAt(idx) != '0'){
            int num = Integer.parseInt(s.substring(idx,idx+2));
            if(num <= 26){
                ways += help(s,idx+2,dp);
            }
        }

        return dp[idx] = ways;
    }
}
