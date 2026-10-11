class Solution {
    public int maxProduct(int[] nums) {

        int maxPro = Integer.MIN_VALUE;
        int pre = 1,suff = 1;
        for(int i = 0;i<nums.length;i++){
            if(pre == 0){pre =1;}
            if(suff == 0){suff = 1;}

            pre *= nums[i];
            suff *= nums[nums.length-i-1];

            maxPro = Math.max(maxPro,Math.max(pre,suff));
        }
        
        return maxPro;
    }
}