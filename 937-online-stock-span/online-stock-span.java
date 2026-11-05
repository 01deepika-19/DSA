class StockSpanner {

    List<Integer> l;
    public StockSpanner() {
        l = new ArrayList<>();
    }
    
    public int next(int price) {
        l.add(price);
        int cnt = 1;
        for(int i = l.size()-2;i>=0;i--){
            if(l.get(i) <= price){
                cnt++;
            }else{
                break;
            }
        }
        return cnt;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */