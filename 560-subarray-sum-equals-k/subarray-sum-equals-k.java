class Solution {
    public int subarraySum(int[] a, int k) {
           
   HashMap<Integer,Integer> map = new HashMap<>();
   int cnt =0;
   int preSum=0;
   map.put(0,1);
   for(int i = 0;i<a.length;i++){
    preSum +=a[i];
    if(map.containsKey(preSum-k)){
        cnt+=map.get(preSum-k);
    }
    map.put(preSum,map.getOrDefault(preSum,0)+1);
   }
  return cnt;
    }
}