class Solution {
    public int[] countBits(int n) {
        int ans[]=new int[n+1];

        for(int num = 0;num<=n;num++){
            int cnt = 0;
            for(int bitindex  = 0;bitindex <32;bitindex++){
                if( (num & 1 << bitindex) != 0){
                    cnt++;
                }
            }
            ans[num]=cnt;
        }
        return ans;
    }
}