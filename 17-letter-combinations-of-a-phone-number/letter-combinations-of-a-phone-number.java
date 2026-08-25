class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        String map[]={ "","", "abc" ,"def" ,"ghi","jkl","mno","pqrs","tuv","wxyz"};
        StringBuilder sb = new StringBuilder();
        generate(0,sb,digits,map,ans);
        return ans;
    }
    private void generate(int index,StringBuilder sb,String digits,String map[],List<String> ans){
        if(index==digits.length()){
            ans.add(sb.toString());
            return;
        }
        String letters = map[digits.charAt(index)- '0'];
        for(char ch : letters.toCharArray()){
            sb.append(ch);
            generate(index+1,sb,digits,map,ans);
            sb.deleteCharAt(sb.length()-1);
        }
    }

}