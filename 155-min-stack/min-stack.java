class MinStack {
    Deque<Long> st;
    long min ;
    public MinStack() {
        st = new ArrayDeque<>();
    }
    
    public void push(int value) {
        if(st.isEmpty()){
            st.push((long)value);
            min=value;
        }else if(value > min){
            st.push((long)value);
        }else{
            long encoded = 2L*value-min;
            st.push(encoded);
            min=value;
        }
    }
    
    public void pop() {
        if(st.peek()>min){
            st.pop();
        }else{
            long encoded = st.pop();
            long prevMin = 2L*min-encoded;
            min=prevMin;
        }
    }
    
    public int top() {
        if(st.peek()>min){
            return st.peek().intValue();
        }else{
            return (int)min;
        }
    }
    
    public int getMin() {
        return (int)min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */