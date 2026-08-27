class Solution {
    public int findNumbers(int[] nums) {
        return count(nums,0);
    }
    private int count(int arr[],int index){
        if(index==arr.length){
            return 0;
        }
        int digits = 0;
        int num=arr[index];
        while(num > 0){
            digits++;
            num/=10;
        }
        if(digits%2==0){
            return 1+count(arr,index+1);
        }else{
            return count(arr,index+1);
        }
    }
}