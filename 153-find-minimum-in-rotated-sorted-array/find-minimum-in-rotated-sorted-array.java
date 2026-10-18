class Solution {
    public int findMin(int[] a) {
        
        int low =  0,high = a.length-1;
        int ans = Integer.MAX_VALUE;
        while(low <= high){
            
            int mid = (low+high)/2;

            if(a[low]<=a[high]){
                ans = Math.min(ans,a[low]);
                break;
            }
            if(a[low]<= a[mid]){
                ans= Math.min(ans, a[low]);
                low = mid+1;
            }else{
                ans = Math.min(ans,a[mid]);
                high = mid-1;
            }
        }
        return ans;
    }
}