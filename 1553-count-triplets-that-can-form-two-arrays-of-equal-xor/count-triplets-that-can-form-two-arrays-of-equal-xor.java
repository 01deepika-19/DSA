class Solution {
    public int countTriplets(int[] arr) {
        int cnt = 0;
        for(int i = 0;i<arr.length;i++){
            for(int j = i+1;j<arr.length;j++){
                int xora= 0;
                for(int k = i;k<j;k++){
                    xora ^= arr[k];
                }

                int xorb = 0;
                for(int k = j;k<arr.length;k++){
                    xorb^=arr[k];
                    if(xora==xorb){
                    cnt++;
                    }
                }
            }
        }
        return cnt;
    }
}