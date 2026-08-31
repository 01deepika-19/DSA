class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        boolean used[]=new boolean[nums.length];
        List<List<Integer>> ans = new ArrayList<>();
        solve(nums,used,new ArrayList<>(),ans);
        return ans;
    }

    private void solve(int nums[],boolean used[],List<Integer> l,List<List<Integer>> ans){

        if(l.size()==nums.length){
            ans.add(new ArrayList<>(l));
            return;
        }

        for(int i = 0;i<nums.length;i++){

            if(used[i]){
                continue;
            }
            if(i > 0 && nums[i]==nums[i-1] && !used[i-1]){
                continue;
            }
            
            l.add(nums[i]);
            used[i]=true;

            solve(nums,used,l,ans);

            used[i]=false;
            l.remove(l.size()-1);
        }
    }
}