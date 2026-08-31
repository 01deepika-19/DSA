class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean used[]=new boolean[nums.length];
        solve(nums,used,new ArrayList<>(),ans);
        return ans;
    }

    private void solve(int nums[],boolean used[],List<Integer> p,List<List<Integer>> ans){

        if(p.size()==nums.length){
            ans.add(new ArrayList<>(p));
            return;
        }

        for(int i = 0;i<nums.length;i++){
            if(used[i]){
                continue;
            }

            p.add(nums[i]);
            used[i]=true;

            solve(nums,used,p,ans);

            used[i]=false;
            p.remove(p.size()-1);
        }
    }
}