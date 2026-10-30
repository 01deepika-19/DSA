class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int left[]=new int[n];
        int right[]=new int[n];

        pse(heights,left);
        nse(heights,right);

        int max = 0;
        for(int i = 0;i<n;i++){
            max = Math.max(max,heights[i]*(right[i]-left[i]-1));
        }
        return max;    
    }

    static void pse(int a[],int left[]){
        int n = a.length;
        Deque<Integer> st = new ArrayDeque<>();

        for(int i = 0;i<n;i++){
            while(!st.isEmpty() && a[st.peek()]>=a[i]){
                st.pop();
            }
            left[i]=st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
    }
    static void nse(int a[],int right[]){
        int n = a.length;
        Deque<Integer> st = new ArrayDeque<>();

        for(int i = n-1;i>=0;i--){
            while(!st.isEmpty() && a[st.peek()]>a[i]){
                st.pop();
            }
            right[i]=st.isEmpty() ? n : st.peek();
            st.push(i);
        }  
    }
}