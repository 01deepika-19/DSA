class Solution {
    public int maxScore(int[] nums, int k) {

        int lsum = 0,rsum=0,max=0,rind=nums.length-1;
        for(int i = 0;i<k;i++){
            lsum +=nums[i];
        }
        max=lsum;
        for(int j = k-1;j>=0;j--){
            lsum -=nums[j];
            rsum +=nums[rind];
            rind--;
            max=Math.max(max,lsum+rsum);
        }
    return max;
    }
}