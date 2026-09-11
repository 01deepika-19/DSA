class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int answer[]=new int[queries.length];

        for(int i = 0;i<queries.length;i++){
            int l = queries[i][0];
            int r = queries[i][1];

            int xor = 0;
            for(int j = l;j<=r;j++){
                xor ^= arr[j];
            }
            answer[i]=xor;
        }
        return answer;
    }
}