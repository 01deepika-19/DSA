class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        return generate(0,target,new ArrayList<>(),candidates);
    }

    private List<List<Integer>> generate(int ind,int target,List<Integer>l,int arr[]){
        
        List<List<Integer>> ans = new ArrayList<>();
        if(ind == arr.length){
            if(target == 0){
                ans.add(new ArrayList<>(l));
            }
            return ans;
        }

        if(arr[ind] <= target){
            l.add(arr[ind]);
            ans.addAll(generate(ind,target-arr[ind],l,arr));
            l.remove(l.size()-1);
        }

        ans.addAll(generate(ind+1,target,l,arr));

        return ans;
    }
}