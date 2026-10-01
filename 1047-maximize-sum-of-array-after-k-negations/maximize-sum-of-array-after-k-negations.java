class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        
        while(k > 0){
            int minIdx = 0;
            for(int i = 0;i<nums.length;i++){
                if(nums[i]<nums[minIdx]){
                    minIdx = i;
                }
            }
            nums[minIdx] = -nums[minIdx];
            k--;
        }

        int sum = 0;
        for(int j = 0;j<nums.length;j++){
            sum += nums[j];
        }
        return sum;
    }
}