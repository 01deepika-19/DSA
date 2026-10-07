class Solution {
    public void sortColors(int[] a) {
        int low=0;
        int mid=0;
        int high= a.length-1;;
        while(mid <=high){
            if(a[mid]==0){
                int temp = a[mid];
                a[mid]=a[low];
                a[low]=temp;
                low++;
                mid++;
            }else if(a[mid]==1){
                mid++;
            }else{
                int temp = a[mid];
                a[mid]=a[high];
                a[high]=temp;
                high--;
            }
        }
    }
}