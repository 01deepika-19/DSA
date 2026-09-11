class Solution {
    public int countTriplets(int[] arr) {
        int cnt = 0;
        for(int i = 0;i<arr.length;i++){
            for(int k = i+1;k<arr.length;k++){
                int xor = 0;
                for(int f = i;f<=k;f++){
                    xor^=arr[f];
                }
                if(xor == 0){
                    cnt += (k-i);
                }
            }
        }
        return cnt;
    }
}