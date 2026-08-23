class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        
        List<List<Integer>> ans = new ArrayList<>();
        generate(0,new ArrayList<>(),ans,nums);
        return ans;
    }

    private void generate(int index,List<Integer> list,List<List<Integer>> ans,int arr[]){
        if(list.size()>=2){
            ans.add(new ArrayList<>(list));
        }
        if(index == arr.length){
            return;
        }
        HashSet<Integer> set = new HashSet<>();
        for(int i = index;i<arr.length;i++){
            if(set.contains(arr[i])){
                continue;
            }
            if(!list.isEmpty() && arr[i] < list.get(list.size()-1)){
                continue;
            }
            set.add(arr[i]);
            list.add(arr[i]);
            generate(i+1,list,ans,arr);
            list.remove(list.size()-1);
        }
    }
}