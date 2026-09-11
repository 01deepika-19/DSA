class Solution {
    public int maxProduct(String[] words) {
        int ans = 0;
        for(int i = 0;i<words.length;i++){
            boolean present[] = new boolean[26];
            for(char c : words[i].toCharArray()){
                present[c-'a']=true;
            }
            for(int j = i+1;j<words.length;j++){
                boolean common = false;
                for(char ch : words[j].toCharArray()){
                    if(present[ch-'a']){
                        common = true;
                        break;
                    }
                }
                if(!common){
                ans = Math.max(ans,words[i].length()*words[j].length());
                }
            }
        }
        return ans;
    }
}