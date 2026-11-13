class Solution {
    public int shipWithinDays(int[] weights, int days) {

        int low = Arrays.stream(weights).max().getAsInt();
        int high = 0;
        for(int i : weights){
            high +=i;
        }
        while(low <=high){
            int mid = low+(high-low)/2;
            if(reqDays(weights,mid)<=days){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return low;
    }

    static int reqDays(int weights[],int capacity){
        int load = 0,days=1;
        for(int weight : weights){
            if(weight + load > capacity){
                days++;
                load = weight;
            }else{
                load += weight;
            }
        }
        return days;
    }
}