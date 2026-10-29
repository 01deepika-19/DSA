class Solution {
    public long subArrayRanges(int[] nums) {
        return sumMax(nums)-sumMin(nums);
    }

    static long sumMin(int a[]){
        int n = a.length;
        Deque<Integer> st = new ArrayDeque<>();

        int left[]=new int[n];
        int right[]=new int[n];

        for(int i = 0;i<n;i++){
            while(!st.isEmpty() && a[st.peek()]>=a[i]){
                st.pop();
            }
            left[i]=st.isEmpty() ? i+1 : i-st.peek();
            st.push(i);
        }
        st.clear();

        for(int j = n-1;j>=0;j--){
            while(!st.isEmpty() && a[st.peek()] > a[j]){
                st.pop();
            }
            right[j]=st.isEmpty() ? n-j : st.peek()-j;
            st.push(j);
        }
        long sum = 0;
        for(int i = 0;i<n;i++){
            long contribution = (long)a[i]*left[i]*right[i];
            sum +=contribution;
        }
        return sum;
    }

    static long sumMax(int a[]){
        int n = a.length;
        Deque<Integer> st = new ArrayDeque<>();

        int left[]=new int[n];
        int right[]=new int[n];

        for(int i = 0;i<n;i++){
            while(!st.isEmpty() && a[st.peek()]<=a[i]){
                st.pop();
            }
            left[i] = st.isEmpty() ? i+1 : i-st.peek();
            st.push(i);
        }
        st.clear();

        for(int i = n-1;i>=0;i--){
            while(!st.isEmpty() && a[st.peek()] < a[i]){
                st.pop();
            }
            right[i]= st.isEmpty() ? n-i : st.peek()-i;
            st.push(i);
        }

        long sum = 0;
        for(int i = 0;i<n;i++){
            long contribution = (long)a[i]*left[i]*right[i];
            sum += contribution;
        }
        return sum;
    }
}