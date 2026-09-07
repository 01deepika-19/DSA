class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend == Integer.MIN_VALUE && divisor == -1){
            return Integer.MAX_VALUE;
        }
        int sign = (dividend < 0 ^ divisor < 0) ? -1 : 1;
        long dd = Math.abs((long)dividend);
        long dv = Math.abs((long)divisor);
        long ans = 0;
        while(dd >= dv){
            int cnt = 0;
            while(dd >= dv << cnt){
                cnt++;
            }
            dd -= dv << cnt-1;
            ans += 1 << (cnt-1);
        }
        return sign ==1 ? (int)ans : (int)-ans;
    }
}