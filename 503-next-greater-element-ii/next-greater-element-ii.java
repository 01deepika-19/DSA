class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Deque<Integer> st = new ArrayDeque<>();
        int n = nums.length;
        int ans[] = new int[n];
        for(int i = 2*n-1;i>=0;i--){
            int curr = nums[i%n];

            while(!st.isEmpty() && st.peek() <= curr){
                st.pop();
            }

            if(i < n){
                ans[i]=(st.isEmpty()) ? -1 : st.peek();
            }
            st.push(curr);
        }
        return ans;
    }
}