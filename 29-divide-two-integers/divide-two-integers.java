class Solution {
    public int divide(int dividend, int divisor) {
        
        if(dividend == Integer.MIN_VALUE && divisor == -1){
            return Integer.MAX_VALUE;
        }
        
        boolean neg = (dividend < 0 ) ^ (divisor < 0);

        long dividendLong = Math.abs((long)dividend);
        long divisorLong = Math.abs((long)divisor);

        long quotient = 0;

        for(int i = 31;i>=0;i--){
            if((divisorLong << i)<= dividendLong){
                dividendLong -= (divisorLong << i);
                quotient +=(1L << i); 
            }
        }
        return neg ? (int) -quotient : (int)quotient;
    }
}