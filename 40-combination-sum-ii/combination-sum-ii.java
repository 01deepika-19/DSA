class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        generate(0,target,ans,new ArrayList<>(),candidates);
        return ans;
    }

    private void generate(int index,int target, List<List<Integer>> ans,List<Integer> l,int arr[]){

        if(target == 0 ){
            ans.add(new ArrayList<>(l));
            return;
        }
        for(int i = index;i<arr.length;i++){

            if(i>index && arr[i]==arr[i-1]){
                continue;
            }
            if(arr[i]>target){
                break;
            }
            l.add(arr[i]);
            generate(i+1,target-arr[i],ans,l,arr);
            l.remove(l.size()-1);
        }
    }
}