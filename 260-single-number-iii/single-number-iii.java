class Solution {
    public int[] singleNumber(int[] nums) {
        int xor=0;
        for(int i =0;i<nums.length;i++){
            xor ^= nums[i];
        }

        int rightmostbit = xor & (xor-1) ^ xor;
        int b1=0,b2=0;
        for(int j = 0;j<nums.length;j++){
            if( (nums[j] & rightmostbit) != 0){
                b1 ^= nums[j];
            }else{
                b2 ^= nums[j];
            }
        }
        return new int[]{b1,b2};
    }
}