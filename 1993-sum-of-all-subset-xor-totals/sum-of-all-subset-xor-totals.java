class Solution {
    public int subsetXORSum(int[] nums) {
        int totalSub = 1<<nums.length;
        int ans = 0;
        for(int i = 0;i<totalSub;i++){
            int xor = 0;
            for(int j = 0;j<nums.length;j++){
                if( (i & (1<<j)) != 0){
                    xor= xor^nums[j];
                }
            }
            ans +=xor;
        }
        return ans;
    }
}