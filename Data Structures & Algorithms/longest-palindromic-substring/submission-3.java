class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        if(n == 1) return s;
        int[][] dp = new int[n][n];

        int i = 0;

        while(i < n){
            dp[i][i] = 1;
            i++;
        }

        i = 0;
        while(i+1 < n){
            if(s.charAt(i) == s.charAt(i+1)){
                dp[i][i+1] = 1;
            }
            i++;
        }

        String ans = "";

        for(int size = 2; size < n; size++){
            for(i = 0; i+size < n; i++){
                int j = i+size;
                if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1] == 1){
                    dp[i][j] = 1;
                }
            }
        }

        for(i = 0; i < n; i++){
            int idx = -1;
            for(int j = 0; j < n; j++){
                // if(dp[i][j] == 1){
                //     if(idx != -1 && (j-idx+1) > ans.length()) ans = s.substring(idx,j+1);
                //     idx = j;
                //     if((j-idx+1) == 1 && ans.length() == 0) ans = s.substring(j,j+1); 
                // }
                if(dp[i][j] == 1 && ans.length() < (j-i+1)){
                    ans = s.substring(i,j+1);
                }
            }
        }

        // for(int[] a : dp) System.out.println(Arrays.toString(a));

        return ans;
    }
}
