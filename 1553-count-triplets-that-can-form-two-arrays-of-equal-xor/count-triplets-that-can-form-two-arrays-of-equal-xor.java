class Solution {
    public int countTriplets(int[] arr) {
        int cnt = 0;
        int xor = 0;
        HashMap<Integer,Integer> count = new HashMap<>();
        HashMap<Integer,Integer> sum = new HashMap<>();
        count.put(0,1);
        sum.put(0,0);
        for(int i = 0;i<arr.length;i++){
            xor ^= arr[i];
            if(count.containsKey(xor)){
                cnt += count.get(xor)*i - sum.get(xor);
            }
            count.put(xor,count.getOrDefault(xor,0)+1);
            sum.put(xor,sum.getOrDefault(xor,0)+i+1);
        }
        return cnt;
    }
}