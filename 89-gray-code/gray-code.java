class Solution {
    public List<Integer> grayCode(int n) {
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0;i< (1<<n);i++){
            ans.add(i^(i>>1));
        }
        return ans;
    }
}