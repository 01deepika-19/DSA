class Solution {
    public String removeKdigits(String num, int k) {

        Deque<Character> st = new ArrayDeque<>();

        for(int i = 0;i<num.length();i++){
            char ch = num.charAt(i);
            while(!st.isEmpty() && k>0 && st.peek() > ch){
                st.pop();
                k--;
            }
            st.push(ch);
        }   

        while(k>0){
            st.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.removeLast());
        }

        String ans = sb.toString().replaceFirst("^0+","");
        return ans.isEmpty() ? "0" : ans;
    }
}