class Solution {
    public int lastRemaining(int n) {
        return solution(n,1,1,true);
    }
    private int solution(int n,int head,int step,boolean left){
        if(n==1){
            return head;
        }
        if(left || n%2==1){
            head+=step;
        }
        return solution(n/2,head,step*2,!left);
    }
}