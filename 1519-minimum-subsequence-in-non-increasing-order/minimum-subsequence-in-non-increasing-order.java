class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        List<Integer> l = new ArrayList<>();
        Arrays.sort(nums);

        int total = 0;
        for(int n : nums){
            total +=n;
        }

        int sum = 0;
        for(int i = nums.length-1;i>=0;i--){
            sum +=nums[i];
            total -=nums[i];
            l.add(nums[i]);
            if(sum > total){
                break;
            }
        }
        return l;
    }
}