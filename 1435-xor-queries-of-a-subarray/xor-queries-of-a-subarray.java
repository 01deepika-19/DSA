class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int answer[]=new int[queries.length];

        int cumXor[]=new int[arr.length];
        cumXor[0]=arr[0];
        for(int i = 1;i<arr.length;i++){
            cumXor[i]=cumXor[i-1]^arr[i];
        }

        for(int i = 0;i<queries.length;i++){
            int l = queries[i][0];
            int r = queries[i][1];
            answer[i]=(l==0 ? 0 : cumXor[l-1])^cumXor[r];
        }
        return answer;
    }
}