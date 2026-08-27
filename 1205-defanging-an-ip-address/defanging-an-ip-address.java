class Solution {
    public String defangIPaddr(String address) {
        return solve(address,0);
    }
    private String solve(String s,int index){
        if(index == s.length()){
            return "";
        }
        char ch = s.charAt(index);
        if(ch == '.'){
            return "[.]" + solve(s,index+1);
        }
        return ch + solve(s,index+1);
    }
}