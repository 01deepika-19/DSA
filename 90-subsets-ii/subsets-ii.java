class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums){
        Arrays.sort(nums);
        List<Integer> l = new ArrayList<>();
        return generate(0,l,nums);
    }
    private List<List<Integer>> generate(int index,List<Integer> l,int arr[]){
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>(l));
        for(int i = index;i<arr.length;i++){
            if(index!=i && arr[i] == arr[i-1]){continue;}
            l.add(arr[i]);
            ans.addAll(generate(i+1,l,arr));
            l.remove(l.size()-1);
        }
        return ans;
    }
}