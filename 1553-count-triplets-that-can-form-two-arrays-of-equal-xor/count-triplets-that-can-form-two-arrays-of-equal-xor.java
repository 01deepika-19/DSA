class Solution {
    public int countTriplets(int[] arr) {
        int cnt = 0;
        int prefixXor[]=new int[arr.length];
        prefixXor[0]=arr[0];
        for(int i = 1;i<arr.length;i++){
            prefixXor[i]=prefixXor[i-1]^arr[i];
        }

        for(int i = 0;i<arr.length;i++){
            for(int k = i+1;k<arr.length;k++){
                if(((i==0 ? 0 : prefixXor[i-1]) ^ prefixXor[k]) == 0){
                    cnt +=(k-i);
                }
            }
        }
        return cnt;
    }
}