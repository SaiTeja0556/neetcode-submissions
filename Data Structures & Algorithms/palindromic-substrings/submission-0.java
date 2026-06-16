class Solution {
    public int countSubstrings(String s) {
        int n = s.length();

        boolean[][] dp = new boolean[n][n];

        int idx = 0;

        while(idx < n){
            dp[idx][idx] = true;
            idx++;
        }

        idx = 0;

        while((idx+1) < n){
            if(s.charAt(idx) == s.charAt(idx+1)){
                dp[idx][idx+1] = true;
            }
            idx++;
        }

        for(int size = 2; size < n; size++){
            for(int i = 0; (i+size) < n; i++){
                int j = i+size;
                if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1]){
                    dp[i][j] = true;
                }
            }
        }

        int cnt = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(dp[i][j]){
                    cnt++;
                }
            }
        }

        return cnt;
    }
}
