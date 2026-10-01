class Solution {
    public int jump(int[] nums) {

        if(nums.length==1){return 0;}
        int jumps = 0,farthest = 0,lastjumpidx=0;
        int destinationIndex = nums.length-1;

        for(int i = 0;i<nums.length;i++){
            farthest = Math.max(farthest,i+nums[i]);

            if(i==lastjumpidx){
                lastjumpidx = farthest;
                jumps++;
            
            if(farthest >= destinationIndex){
                return jumps;
            }
            }
        }
        return jumps;
    }
}