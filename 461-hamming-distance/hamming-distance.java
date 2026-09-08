class Solution {
    public int hammingDistance(int x, int y) {
        int xor = x^y;
        int cnt = 0;
        while(xor != 0){
            xor = xor & (xor-1);
            cnt++;
        }
        return cnt;
    }
}