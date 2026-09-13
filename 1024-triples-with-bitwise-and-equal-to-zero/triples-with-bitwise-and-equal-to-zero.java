class Solution {
    public int countTriplets(int[] nums) {
        int n = nums.length;
        int ans = 0;
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                int value = nums[i] & nums[j];
                map.put(value,map.getOrDefault(value,0)+1);
            }
        }

        for(int k = 0;k<n;k++){
            for(Map.Entry<Integer,Integer> entry : map.entrySet()){
                int andPair = entry.getKey();
                int freq = entry.getValue();
                if((andPair & nums[k]) == 0){
                    ans +=freq;
                }
            }
        }
        return ans;
    }
}