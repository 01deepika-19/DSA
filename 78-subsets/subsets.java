class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> l=new ArrayList<>();
        return generate(0,l,nums);
    }

    private List<List<Integer>> generate(int index,List<Integer> l,int arr[]){
        List<List<Integer>> ans = new ArrayList<>();
        if(index >= arr.length){
            ans.add(new ArrayList<>(l));
            return ans;
        }
        l.add(arr[index]);
        ans.addAll(generate(index+1,l,arr));
        l.remove(l.size()-1);
        ans.addAll(generate(index+1,l,arr));
        return ans;
    }
}