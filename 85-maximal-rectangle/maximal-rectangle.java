class Solution {
    public int maximalRectangle(char[][] matrix) {

        int n = matrix.length;
        int m = matrix[0].length;
        int prefixSum[][] = new int[n][m];

        for(int j = 0;j<m;j++){
            int sum = 0;
            for(int i = 0;i<n;i++){
                sum += matrix[i][j]-'0';
                if(matrix[i][j]=='0'){
                    sum=0;
                }
                prefixSum[i][j]=sum;
            }
        }

        int max = 0;
        for(int i = 0;i<n;i++){
            max = Math.max(max,largestHistogram(prefixSum[i]));
        }
        return max;
    }

    public int largestHistogram(int a[]){

        Deque<Integer> st = new ArrayDeque<>();
        int max = 0;
        for(int i = 0;i<a.length;i++){
            while(!st.isEmpty() && a[st.peek()]>a[i]){
                int element = a[st.pop()];
                int nse = i;
                int pse = st.isEmpty() ? -1 : st.peek();
                max = Math.max(max,element * (nse-pse-1));
            }
            st.push(i);
        }

        while(!st.isEmpty()){
            int nse = a.length;
            int e = a[st.pop()];
            int pse = st.isEmpty() ? -1 : st.peek();
            max = Math.max(max,e* (nse-pse-1));
        }
        return max;
    }
}