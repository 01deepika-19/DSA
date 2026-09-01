class Solution {
    public int maxUniqueSplit(String s) {
        
        HashSet<String> set = new HashSet<>();
        return solve(0,set,s);
    }
    private int solve(int index,HashSet<String> set,String s){
        if(index == s.length()){
            return 0;
        }
        int max=0;
        for(int i = index;i<s.length();i++){
            String sub = s.substring(index,i+1);
            if(!set.contains(sub)){
                 set.add(sub);
                 max=Math.max(max,1+solve(i+1,set,s));
                 set.remove(sub);
            }
        }
        return max;
    }
}