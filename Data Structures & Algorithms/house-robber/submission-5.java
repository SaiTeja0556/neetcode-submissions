class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        int p1 = nums[0],p2 = 0;

        for(int i = 1; i < n; i++){
            int pick = p2 + nums[i];
            int notpick = p1 ;

            int curr = Math.max(pick,notpick);

            p2 = p1;
            p1 = curr;
        }

        return p1;
    }
}
