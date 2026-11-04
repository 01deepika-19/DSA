class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        
        Arrays.sort(intervals,(a,b)-> Integer.compare(a[1],b[1]));
        int removals= 0;
        int prevEnd = Integer.MIN_VALUE;
        for(int interval[] : intervals){
            int endt = interval[1];
            int startt=interval[0];
            if( startt >= prevEnd){
                prevEnd = endt;
            }else{
                removals++;
            }
        }
        return removals;
    }
}