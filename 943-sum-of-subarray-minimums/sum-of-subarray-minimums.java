class Solution {


    static void pse(int left[],int arr[]){

        Deque<Integer> st = new ArrayDeque<>();
        for(int i = 0;i<arr.length;i++){

            while(!st.isEmpty() && arr[st.peek()] >=arr[i]){
                st.pop();
            }
            left[i]=st.isEmpty() ? i+1 : i-st.peek();
            st.push(i);
        }
    }

    static void nse(int right[],int arr[]){
        int n = arr.length;
        Deque<Integer> st = new ArrayDeque<>();
        for(int i = arr.length-1;i>=0;i--){

            while(!st.isEmpty() && arr[st.peek()] > arr[i]){
                st.pop();
            }

            right[i]=st.isEmpty() ? n-i : st.peek()-i;
            st.push(i);
        }
    }
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int mod = (int)1e9+7;
        long sum = 0;

        int left[] = new int[n];
        int right[] = new int[n];
        pse(left,arr);
        nse(right,arr);

        for(int i = 0;i<n;i++){
            long contribution = (long)arr[i]*left[i]*right[i];
            sum = (sum + contribution)%mod;
        }
        return (int)sum;
    }
}