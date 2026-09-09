class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int maxOr = 0;
        for(int n : nums){
            maxOr |= n;
        }
        int cnt = 0;
        for(int mask = 0;mask < (1<<nums.length);mask++){
            int or = 0;
            for(int i = 0;i<nums.length;i++){
                if((mask & (1<<i)) != 0){
                    or |= nums[i];
                }
            }
            if(or == maxOr){
                cnt++;
            }
        }
        return cnt;
    }
}