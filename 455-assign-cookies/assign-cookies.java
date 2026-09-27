class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0,j=0;

        while(j<s.length && i< g.length){
            if(s[j]>=g[i]){
                i++;
            }
            j++;
        }
        return i;
    }
}