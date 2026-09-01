class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> nums = new ArrayList<>();
        int factorial=1;
        for(int i = 1;i<n;i++){
            factorial *=i;
            nums.add(i);
        }
        nums.add(n);
        --k;
        StringBuilder ans = new StringBuilder();
        while(true){

            int index = k/factorial;
            ans.append(nums.get(index));
            nums.remove(index);
            if(nums.size()==0){
                break;
            }
            k=k%factorial;
            factorial = factorial/nums.size();
        }
        return ans.toString();
    }
}