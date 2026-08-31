class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(nums,new ArrayList<>(),ans);
        return ans;
    }

    private void solve(int nums[],List<Integer> p,List<List<Integer>> ans){

        if(p.size()==nums.length){
            ans.add(new ArrayList<>(p));
            return;
        }

        for(int i = 0;i<nums.length;i++){
            if(nums[i]==-11){
                continue;
            }

            p.add(nums[i]);
            int s = nums[i];
            nums[i]=-11;

            solve(nums,p,ans);

            nums[i]=s;
            p.remove(p.size()-1);
        }
    }
}