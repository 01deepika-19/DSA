class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> ans = new ArrayList<>();
        solve(0,s,new StringBuilder(),ans);
        return ans;
    }

    private void solve(int index,String s,StringBuilder sb,List<String> ans){

        if(index==s.length()){
            ans.add(sb.toString());
            return;
        }

        char c= s.charAt(index);
        if(Character.isLetter(c)){

            sb.append(Character.toUpperCase(c));
            solve(index+1,s,sb,ans);
            sb.deleteCharAt(sb.length()-1);

            sb.append(Character.toLowerCase(c));
            solve(index+1,s,sb,ans);
            sb.deleteCharAt(sb.length()-1);
        }else{
            sb.append(c);
            solve(index+1,s,sb,ans);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}