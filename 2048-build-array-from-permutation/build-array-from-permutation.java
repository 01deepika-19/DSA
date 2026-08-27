class Solution {
    public int[] buildArray(int[] nums) {
        int ans[]=new int[nums.length];
        generate(nums,ans,0);
        return ans;
    }
    private void generate(int nums[],int ans[],int index){
        if(index==nums.length){
            return;
        }
        ans[index]=nums[nums[index]];
        generate(nums,ans,index+1);
    }
}