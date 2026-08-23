class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        int arr[]={1,2,3,4,5,6,7,8,9};
        List<List<Integer>> ans = new ArrayList<>();
        generate(0,n,ans,new ArrayList<>(),arr,k,0);
        return ans;
    }

    private void generate(int index,int target, List<List<Integer>> ans,List<Integer> l,int arr[],int k,int count){

        if(count > k){
            return;
        }
        if(count == k && target == 0 ){
            ans.add(new ArrayList<>(l));
            return;
        }
        for(int i = index;i<arr.length;i++){
            if(arr[i]>target){
                break;
            }
            l.add(arr[i]);
            generate(i+1,target-arr[i],ans,l,arr,k,count+1);
            l.remove(l.size()-1);
        }
    }
}